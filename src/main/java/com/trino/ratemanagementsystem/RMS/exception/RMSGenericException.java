package com.trino.ratemanagementsystem.RMS.exception;

import org.springframework.http.HttpStatus;

public class RMSGenericException extends RuntimeException {

    String msg;
    HttpStatus status;

    public RMSGenericException(String msg, HttpStatus status) {
        this.msg = msg;
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
