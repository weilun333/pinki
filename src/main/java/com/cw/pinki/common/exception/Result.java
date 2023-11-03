package com.cw.pinki.common.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Schema(description = "api通用返回對象")
@ToString
@Data
public class Result<T> implements Serializable {
    @Schema(description = "code 1:成功 其他數值表示異常")
    private Integer code;

    @Schema(description = "錯誤訊息")
    private String msg;

    @Schema(description = "返回數值")
    private T data;

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
