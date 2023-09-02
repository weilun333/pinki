package com.cw.pinki.common.exception;

public class DescribeException extends  RuntimeException{
    private Integer code;

    public DescribeException(String message, Integer code){
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
