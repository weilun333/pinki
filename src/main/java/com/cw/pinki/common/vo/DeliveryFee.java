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
@Table(name = "delivery_fee")
public class DeliveryFee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deliver_no")
    private Integer deliverNo;

    @Column(name = "brand_no")
    private Integer brandNo;

    @Column(name = "prod_size")
    private Integer prodSize;

    @Column(name = "deliver_fee")
    private Integer deliverFee;

    @Column(name = "free_delivery_amount")
    private Integer freeDeliveryAmount;

    @Column(name = "process_user")
    private String processUser;

    @Column(name = "last_update_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date lastUpdateTime;
}
