package com.netty4.server.exception;

public class ParamNullException extends RuntimeException{

    private String paramName;

    public ParamNullException(String paramName) {
        super(paramName+": is empty");
        this.paramName=paramName;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }


}
