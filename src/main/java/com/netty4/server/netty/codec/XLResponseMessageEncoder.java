package com.netty4.server.netty.codec;


import com.netty4.server.netty.XLResponse;
import com.netty4.server.netty.util.ProtocolUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Set;

/**
 * Created by james on 2018/6/30.
 * 组包
 */
public class XLResponseMessageEncoder extends MessageToByteEncoder<XLResponse> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, XLResponse response, ByteBuf byteBuf) throws Exception {
        byteBuf.writeBytes(encodeResponse(response));
    }

    public byte[] encodeResponse(XLResponse response) {
        try {
            ByteBuffer headBuffer = ByteBuffer.allocate(16);

            //先组织报文头
            headBuffer.put(response.getEncode());
            headBuffer.put(response.getEncrypt());
            headBuffer.put(response.getExtend1());
            headBuffer.put(response.getExtend2());
            headBuffer.putInt(response.getSessionid());
            headBuffer.putInt(response.getResult());

             //组织报文的数据部分
            Map<String, String> properties = response.getValues();
            Set<Map.Entry<String, String>> propertiesSet= properties.entrySet();
            ByteArrayOutputStream bodyStream = new ByteArrayOutputStream();
            for (Map.Entry<String, String> property : propertiesSet) {
                String propertyName = property.getKey();
                String propertyValue = property.getValue();
                bodyStream.write(ProtocolUtil.stringToByteArray(propertyName, "utf-8"));
                bodyStream.write(ProtocolUtil.stringToByteArray(propertyValue, "utf-8"));
            }
            byte[] bodyBytes = bodyStream.toByteArray();// 数据部分
            headBuffer.putInt(bodyBytes.length);
            bodyStream.close();

            ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
            responseStream.write(headBuffer.array());
            responseStream.write(bodyBytes);
            byte[] responseBytes = responseStream.toByteArray();// 整个响应包
            responseStream.close();
            return responseBytes;
        } catch (Exception e) {
            return null;
        }
    }
}
