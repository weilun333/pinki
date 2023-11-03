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
@Table(name = "daily_check_in_log")
public class DailyCheckInLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "check_in_no")
    private Integer checkInNo;

    @Column(name = "member_no")
    private Integer memberNo;

    @Column(name = "receive_point")
    private Integer receivePoint;

    @Column(name = "total_receive_day")
    private Integer totalReceiveDay;

    @Column(name = "process_user")
    private String processUser;

    @Column(name = "last_update_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date lastUpdateTime;

}
