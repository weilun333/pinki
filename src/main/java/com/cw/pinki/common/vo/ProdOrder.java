package com.cw.pinki.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "prod_order")
public class ProdOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_order_no")
    private Integer prodOrderNo;

    @Column(name = "member_no")
    private Integer memberNo;

    @Column(name = "brand_no")
    private Integer brandNo;

    @Column(name = "order_status")
    private Integer orderStatus;

    @Column(name = "prod_order_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date prodOrderTime;

    @Column(name = "prod_deliver_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date prodDeliverTime;

    @Column(name = "prod_order_receive_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date prodOrderReceiveTime;

    @Column(name = "deliver_fee")
    private Integer deliverFee;

    @Column(name = "total_amount")
    private Integer totalAmount;

    @Column(name = "used_coins")
    private Integer usedCoins;

    @Column(name = "activity_no")
    private Integer activityNo;

    @Column(name = "discount_amount")
    private Integer discountAmount;

    @Column(name = "final_amount")
    private Integer finalAmount;

    @Column(name = "bonus_point")
    private Integer bonusPoint;

    @Column(name = "receiver_name")
    private String receiverName;

    @Column(name = "receiver_tel")
    private String receiverTel;

    @Column(name = "receiver_mail")
    private String receiverMail;

    @Column(name = "receiver_addr")
    private String receiverAddr;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "tax_id_number")
    private String taxIdNumber;

    @Column(name = "payment_method_no")
    private Integer paymentMethodNo;

    @Column(name = "payment_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date paymentTime;

    @Column(name = "process_user")
    private String processUser;

    @Column(name = "last_update_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date lastUpdateTime;
}
