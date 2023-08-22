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
@Table(name = "prod_order_detail")
public class ProdOrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_order_no")
    private Integer prodOrderNo;

    @Column(name = "prod_no")
    private Integer prodNo;

    @Column(name = "prod_qty")
    private Integer prodQty;

    @Column(name = "prod_price")
    private Integer prodPrice;

    @Column(name = "order_status")
    private Integer orderStatus;

    @Column(name = "prod_comment_rating")
    private Double prodCommentRating;

    @Column(name = "prod_comment_content")
    private String prodCommentContent;

    @Column(name = "prod_comment_pic")
    private byte[] prodCommentPic;

    @Column(name = "prod_comment_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date prodCommentTime;

    @Column(name = "designer_replay")
    private String designerReplay;

    @Column(name = "designer_replay_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date designerReplayTime;
}
