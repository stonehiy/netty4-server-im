package com.netty4.server.netty;

import com.netty4.server.netty.constant.CommidConfig;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Map;

public class ServerHandler extends SimpleChannelInboundHandler<Map> {
    /**
     * 定义一个集合来存储连上来的客户端
     */
//    private static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


    /**
     * 读取客户端的数据，然后广播给其他客户端，如果是自己给自己发消息则显示: 自己对自己说:xxx 如果是别人的消息则显示:XXX对我说:xxx
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Map msg) throws Exception {
        System.out.println("Map msg : " + msg);
        Channel channel = ctx.channel();
        String serviceName = (String) msg.get(CommidConfig.SERVICE_NAME);
        int sn = Integer.parseInt((String) msg.get(CommidConfig.SN));
        if (CommidConfig.SESSION_LOGIN.equals(serviceName)) {
            //登录
            Request request = new Request(CommidConfig.SESSION_LOGIN, CommidConfig.PUSHTYPE_REQUEST, msg, null);
            request.setSn(sn);
            channel.writeAndFlush(request).addListener(new FutureListener() {
                @Override
                public void success() {
//                    group.add(channel);
                    NettyServer.mUsers.put(CommidConfig.USER_ID, channel);
                    System.out.println("回复成功--->" + request.getServiceName());
                }

                @Override
                public void error() {
                    System.out.println("回复失败--->" + request.getServiceName());
                }
            });

        } else if (CommidConfig.SYNC_AES_KEY.equals(serviceName)) {
            //接收密匙
            msg.put(CommidConfig.PUSH_TYPE, String.valueOf(CommidConfig.PUSHTYPE_REQUEST));
            Request request = new Request(CommidConfig.SYNC_AES_KEY, CommidConfig.PUSHTYPE_REQUEST, msg, null);
            request.setSn(sn);
            channel.writeAndFlush(request).addListener(new FutureListener() {
                @Override
                public void success() {
                    System.out.println("回复成功--->" + request.getServiceName());
                }

                @Override
                public void error() {
                    System.out.println("回复失败--->" + request.getServiceName());
                }
            });
        }
    }

    /**
     * 客户端连上服务器的时候通知其他的客户端，XXX连上服务器了
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("【服务器端消息】:" + channel.remoteAddress() + "加入了\n"); //调用集合的写方法会通知到所有在集合中的客户端
        System.out.println("【服务器端消息】:" + channel.id().asShortText());
        //先调用group的写方法在加入，则可以避免对自己写入
//        group.add(channel);
    }

    /**
     * 当客户端断开的时候通知其他的客户端XXX失去服务器端的连接了
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channel.close();
        NettyServer.removeUser(channel);
        //group.remove(channel); //删除某一个客户端，但是没有必要显示的调用，ChannelGroup会自动检查是否在线
        System.out.println("【服务器端消息】:" + channel.remoteAddress() + "离开了\n");
    }

    /**
     * 客户端上线的时候，通知其他客户端,XXX上线了
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("【服务器端消息】:" + channel.remoteAddress() + "上线了");
        System.out.println("【服务器端消息】:" + channel.id().asLongText());
    }

    /**
     * 当客户端下线的时候，通知其他的客户端,XXX下线了
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channel.close();
        NettyServer.removeUser(channel);
        System.out.println("【服务器端消息】:" + channel.remoteAddress() + "下线了");
    }

    /**
     * 出现异常的时候关闭客户端
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        Channel channel = ctx.channel();
        channel.close();
        ctx.close();
        NettyServer.removeUser(channel);
    }
}
