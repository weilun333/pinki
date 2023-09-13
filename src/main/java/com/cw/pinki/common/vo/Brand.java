package com.cw.pinki.common.vo;

import com.cw.pinki.common.annotation.ValidPassword;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_no")
    private Integer brandNo;

    @NotNull(message = "品牌名稱不得為空")
    @Column(name = "brand_name")
    private String brandName;

    @NotNull(message = "帳號不得為空")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "不符合e-mail格式，請確認")
    @Column(name = "designer_account")
    private String designerAccount;

    @ValidPassword
    @NotNull(message = "密碼不得為空")
    @Column(name = "designer_password")
    private String designerPassword;

    @NotNull(message = "統一編號不得為空")
    @Pattern(regexp = "^[0-9]{8}$", message = "統一編號須為8位數")
    @Column(name = "tax_id_no")
    private String taxIdNo;

    @Column(name = "brand_tel")
    private String brandTel;

    @Column(name = "brand_addr")
    private String brandAddr;

    @NotNull(message = "銀行代碼不得為空")
    @Column(name = "bank_no")
    private String bankNo;

    @NotNull(message = "須設定收款銀行帳戶")
    @Column(name = "bank_account")
    private String bankAccount;

    @NotNull(message = "品牌簡介不得為空")
    @Column(name = "brand_story")
    private String brandStory;

    //    @NotNull(message = "須設定品牌logo")
    @Column(name = "brand_logo")
    private byte[] brandLogo;

    //    @NotNull(message = "須設定封面照片")
    @Column(name = "cover_pic")
    private byte[] coverPic;

    @Column(name = "designer_status")
    private Boolean designerStatus;

    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @Column(name = "process_user")
    private String processUser;

    @Column(name = "last_update_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastUpdateTime;
}
