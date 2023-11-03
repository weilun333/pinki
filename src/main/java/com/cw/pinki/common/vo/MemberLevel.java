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
@Table(name = "member_level")
public class MemberLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_no")
    private Integer levelNo;

    @Column(name = "level_name")
    private String levelName;

    @Column(name = "upper_total_amount")
    private Integer upperTotalAmount;

    @Column(name = "lower_total_amount")
    private Integer lowerTotalAmount;

    @Column(name = "one_time_consumption")
    private Integer oneTimeConsumption;

    @Column(name = "process_user")
    private String processUser;

    @Column(name = "last_update_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date lastUpdateTime;

}
