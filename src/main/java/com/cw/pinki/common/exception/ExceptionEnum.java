package com.cw.pinki.common.exception;

public enum ExceptionEnum {
    INCOMPLETE_INFO(0,"註冊資訊不完整"),
    DUPLICATED_NAME(0,"名稱不可重複"),
    DUPLICATED_ACCOUNT(0,"帳號不可重複"),
    INCORRECT_INFO(1,"輸入資訊不存在"),
    INCORRECT_PASSWORD_ACCOUNT(1,"帳號或密碼錯誤")
    ;

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
