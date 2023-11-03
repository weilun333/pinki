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
@Table(name = "daily_check_in_config")
public class DailyCheckInConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "check_in_no")
    private Integer checkInNo;

    @Column(name = "level_no")
    private Integer levelNo;

    @Column(name = "check_in_point")
    private Integer checkInPoint;

    @Column(name = "increase_point")
    private Integer increasePoint;

    @Column(name = "max_day")
    private Integer maxDay;

    @Column(name = "process_user")
    private String processUser;

    @Column(name = "last_update_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date lastUpdateTime;

}
