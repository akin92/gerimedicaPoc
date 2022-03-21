package com.logicbig.example.model;

public class ResponseError {
    String error;
    String desc;

    public ResponseError(String error, String desc) {
        this.error = error;
        this.desc = desc;
    }

    public ResponseError() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
