package com.cw.pinki.common.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.cw.pinki.common.annotation.ValidPassword;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Integer memberNo;

    @NotBlank(message = "會員姓名不得為空")
    @Column(name = "name")
    private String name;

    @Past(message = "生日不可為未來日期")
    @Column(name = "birthday")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @NotBlank(message = "會員信箱不得為空")
    @Pattern(regexp = "^\\w{1,63}@[a-zA-Z0-9]{2,63}\\.[a-zA-Z]{2,63}(\\.[a-zA-Z]{2,63})?$", message = "不符合e-mail格式，請確認")
    @Column(name = "mail")
    private String mail;

    @ValidPassword
    @NotBlank(message = "密碼不得為空")
    @Column(name = "member_password")
    private String memberPassword;

    @Column(name = "subscription")
    private Boolean subscription;

    @Column(name = "tel")
    private String tel;

    @Column(name = "level_no")
    private Integer levelNo;

    @Column(name = "address")
    private String address;

    @Column(name = "member_status")
    private Boolean memberStatus;

    @Column(name = "coins")
    private Integer coins;

    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @Column(name = "process_user")
    private String processUser;

    @Column(name = "last_update_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastUpdateTime;

}
