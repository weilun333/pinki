package com.cw.pinki.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "bank_account")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_no")
    private Integer accountNo;

    // 1: 銀行帳號
    @Column(name = "payment_method_no")
    private Integer paymentMethodNo;

    // 1: 會員 2: 品牌
    @Column(name = "member_type")
    private Integer memberType;

    @Column(name = "member_no")
    private Integer memberNo;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "bank_no")
    private String bankNo;

    @Column(name = "expire_date")
    private String expireDate;

    @Column(name = "is_usual_account")
    private Boolean isUsualAccount;

    @Column(name = "process_user")
    private String processUser;

    @Column(name = "last_update_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone= "GMT+8")
    private Date lastUpdateTime;

}
