package com.cw.pinki.common.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class BrandLoginDto {

    @NotNull(message = "帳號不得為空")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "不符合e-mail格式，請確認")
    private String designerAccount;

    @NotNull(message = "密碼不得為空")
    private String designerPassword;
}
