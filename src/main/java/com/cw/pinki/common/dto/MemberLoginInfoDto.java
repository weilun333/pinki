package com.cw.pinki.common.dto;

import com.cw.pinki.common.annotation.ValidPassword;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class MemberLoginInfoDto {
    @NotBlank(message = "會員信箱不得為空")
    @Pattern(regexp = "^\\w{1,63}@[a-zA-Z0-9]{2,63}\\.[a-zA-Z]{2,63}(\\.[a-zA-Z]{2,63})?$", message = "不符合e-mail格式，請確認")
    private String mail;

    @ValidPassword
    @NotBlank(message = "密碼不得為空")
    private String memberPassword;
}
