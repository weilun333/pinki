package com.cw.pinki.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "brand_name")
    private String BrandName;

    @Column(name = "designer_account")
    private String designerAccount;

    @Column(name = "designer_password")
    private String designerPassword;

    @Column(name = "tax_id_no")
    private String taxIdNo;

    @Column(name = "brand_tel")
    private String brandTel;

    @Column(name = "brand_addr")
    private String brandAddr;

    @Column(name = "bank_account_no")
    private Integer bankAccountNo;

    @Column(name = "brand_story")
    private String brandStory;

    @Column(name = "brand_logo")
    private byte[] brandLogo;

    @Column(name = "cover_pic")
    private byte[] coverPic;

    @Column(name = "designer_status")
    private Boolean designerStatus;

    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone= "GMT+8")
    private Date createTime;

    @Column(name = "process_user")
    private String processUser;

    @Column(name = "last_update_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone= "GMT+8")
    private Date lastUpdateTime;
}
