package com.netty4.server.netty;

import com.netty4.server.netty.constant.CommidConfig;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

import java.util.HashMap;
import java.util.Map;


public class HeartBeatServerHandler extends SimpleChannelInboundHandler<Map> {


    //private static final ByteBuf HEARTBEAT_SEQUENCE = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("Heartbeat", CharsetUtil.UTF_8));

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.WRITER_IDLE) {

            } else if (event.state() == IdleState.READER_IDLE) {
                // 响应超时进行网络关闭
                ctx.disconnect();
            } else {
                super.userEventTriggered(ctx, evt);
            }
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Map msg) throws Exception {
        String serviceName = (String) msg.get(CommidConfig.SERVICE_NAME);
        if (CommidConfig.HEARTBEAT.equals(serviceName)) {
            HashMap<String, String> map = new HashMap<>();
            try {
                Request request = new Request(CommidConfig.HEARTBEAT, 0, map, null);
                ctx.channel().writeAndFlush(request).addListener(new FutureListener() {
                    @Override
                    public void success() {
                        System.out.println("回复成功---> " + CommidConfig.HEARTBEAT);
                    }

                    @Override
                    public void error() {
                        System.out.println("回复失败---> " + CommidConfig.HEARTBEAT);
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            ctx.fireChannelRead(msg);
        }

    }


}