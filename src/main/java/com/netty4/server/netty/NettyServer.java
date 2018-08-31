package com.netty4.server.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NettyServer {

    public static Map<String, Channel> mUsers = new HashMap<>();

    public void init() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ServerInitializer())
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture future = bootstrap.bind(9999).sync();
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

    public static void removeUser(Channel channel) {
        if (null == channel) {
            return;
        }
        if (null == mUsers) {
            return;
        }
        Iterator<Map.Entry<String, Channel>> iterator = mUsers.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Channel> next = iterator.next();
            Channel value = next.getValue();
            if (channel.id().asLongText().equals(value.id().asLongText())) {
                iterator.remove();
                break;
            }
        }


    }


    public static void main(String[] args) throws Exception {
        new NettyServer().init();

    }
}
