package com.cw.pinki.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Integer memberNo;

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Column(name = "mail")
    private String mail;

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
    private Date createTime;

    @Column(name = "process_user")
    private String processUser;

    @Column(name = "last_update_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date lastUpdateTime;
}
