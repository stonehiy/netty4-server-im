package com.netty4.server.netty.constant;

public class CommidConfig {

    //参数关键字
    public static final String SERVICE_NAME = "serviceName";
    public static final String REQ_INFO = "reqInfo";
    public static final String PUSH_TYPE = "pushType";
    public static final String SN = "sn";
    public static final String USER_ID = "userid";
    public static final String SESSION_ID = "sessionid";
    public static final String VERSION = "version";


    //消息类型
    public static final int PUSHTYPE_REQUEST = 1;
    public static final int PUSHTYPE_GAME = 2;
    public static final int PUSHTYPE_NOTIFY = 3;

    //命令关键字
    public static final String SESSION_LOGIN = "sessionlogin";
    public static final String SYNC_AES_KEY = "syncAesKey";
    public static final String HEARTBEAT = "heartbeat";
}
