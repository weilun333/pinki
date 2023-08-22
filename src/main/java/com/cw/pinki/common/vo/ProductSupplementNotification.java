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
@Table(name = "product_supplement_notification")
public class ProductSupplementNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplement_notify_no")
    private Integer supplementNotifyNo;

    @Column(name = "prod_no")
    private Integer prodNo;

    @Column(name = "member_no")
    private Integer memberNo;

    @Column(name = "notify_status")
    private Boolean notifyStatus;

    @Column(name = "process_user")
    private String processUser;

    @Column(name = "last_update_time")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date lastUpdateTime;
}
