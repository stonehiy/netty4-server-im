package com.netty4.server.netty;

import com.netty4.server.netty.codec.MessageDecoder;
import com.netty4.server.netty.codec.MessageEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new LoggingHandler(LogLevel.INFO));    // 开启日志，可以设置日志等级
        //pipeline.addLast("IdleStateHandler", new IdleStateHandler(NetworkConfig.READ_IDLE_TIME_SECOND, NetworkConfig.HEART_BEAT_TIME, 0));
        pipeline.addLast("StringDecoder", new MessageDecoder());//解码器 这里要与服务器保持一致
        pipeline.addLast("StringEncoder", new MessageEncoder());//编码器 这里要与服务器保持一致
        pipeline.addLast(new IdleStateHandler(120, 0, 0, TimeUnit.SECONDS));
        pipeline.addLast(new HeartBeatServerHandler());
        pipeline.addLast(new ServerHandler());


    }
}
