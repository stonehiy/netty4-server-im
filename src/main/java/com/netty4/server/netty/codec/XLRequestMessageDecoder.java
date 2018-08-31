package com.netty4.server.netty.codec;


import com.netty4.server.netty.XLRequest;
import com.netty4.server.netty.util.ProtocolUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务端拆包
 * 拆包,支持处理粘包和半包
 */
public class XLRequestMessageDecoder extends ByteToMessageDecoder {

    private byte[] remainingBytes;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        ByteBuf currBB = null;
        if (remainingBytes == null) {
            currBB = msg;
        } else {
            byte[] tb = new byte[remainingBytes.length + msg.readableBytes()];
            System.arraycopy(remainingBytes, 0, tb, 0, remainingBytes.length);
            byte[] vb = new byte[msg.readableBytes()];
            msg.readBytes(vb);
            System.arraycopy(vb, 0, tb, remainingBytes.length, vb.length);
            currBB = Unpooled.copiedBuffer(tb);
        }
        while (currBB.readableBytes() > 0) {
            if (!doDecode(ctx, currBB, out)) {
                break;
            }
        }
        if (currBB.readableBytes() > 0) {
            remainingBytes = new byte[currBB.readableBytes()];
            currBB.readBytes(remainingBytes);
        } else {
            remainingBytes = null;
        }
    }

    /**
     * @param ctx
     * @param msg
     * @param out
     * @return boolean
     * @Title:doDecode
     */
    private boolean doDecode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {

        //这个表示头长度的字节数。
        //1.msg由包头以及包体组成，小于16byte不处理丢弃掉。
        if (msg.readableBytes() < 16) {
            return false;
        }

        //2.我们标记一下当前的readIndex的位置
        msg.markReaderIndex();

        //解析包头
        // 读取传送过来的消息的长度。ByteBuf 的readInt()方法会让他的readIndex增加4
        byte encode = msg.readByte();//1字节
        byte encrypt = msg.readByte();//1字节
        byte extend1 = msg.readByte();//1字节
        byte extend2 = msg.readByte();//1字节
        int sessionid = msg.readInt();//4字节
        int command = msg.readInt();//4字节
        int len = msg.readInt(); // 4字节-报文体数据包长
        //以上是报文头由16个字节组成，报文头解析完成。
        if (msg.readableBytes() < len) {
            msg.resetReaderIndex();
            return false;
        }

        //解析包体
        byte[] body = new byte[len];
        msg.readBytes(body);


        XLRequest xlRequest = new XLRequest();
        xlRequest.setEncode(encode);
        xlRequest.setEncrypt(encrypt);
        xlRequest.setExtend1(extend1);
        xlRequest.setExtend2(extend2);
        xlRequest.setSessionid(sessionid);
        xlRequest.setCommand(command);
        Map<String, String> properties = decodeProperties(body);
        xlRequest.setParams(properties);

        out.add(xlRequest);
        if (msg.readableBytes() > 0) {
            return true;
        }

        return false;
    }

    private Map<String, String> decodeProperties(byte[] bodyBytes) throws Exception {
        StringBuilder builder = new StringBuilder();
        for (byte b : bodyBytes) {
            builder.append(b).append(',');
        }
        try {
            Map<String, String> properties = new HashMap<>();
            ByteArrayInputStream in = new ByteArrayInputStream(bodyBytes);
            in.skip(0);
            while (in.available() > 0) {
                String propertyName = ProtocolUtil.readString(in, "utf-8");
                String propertyValue = ProtocolUtil.readString(in, "utf-8");
                properties.put(propertyName, propertyValue);
            }
            return properties;
        } catch (Exception e) {
            throw new Exception("DoDecode exception, Received:byte[" + bodyBytes.length + "]{" + builder + "}");
        }
    }
}
