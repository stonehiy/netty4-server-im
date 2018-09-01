package com.netty4.server.exception;

public class TokenTimeoutException extends RuntimeException {

    public TokenTimeoutException(String message) {
        super(message);
    }
}
