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
@Table(name = "prod_info")
public class ProdInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_no")
    private Integer prodNo;

    @Column(name = "prod_pic_no")
    private Integer prodPicNo;

    @Column(name = "brand_no")
    private Integer brandNo;

    @Column(name = "prod_category_no")
    private Integer prodCategoryNo;

    @Column(name = "prod_name")
    private String prodName;

    @Column(name = "prod_price")
    private Integer prodPrice;

    @Column(name = "prod_stock")
    private Integer prodStock;

    @Column(name = "prod_specification")
    private String prodSpecification;

    @Column(name = "prod_content")
    private String prodContent;

    @Column(name = "prod_size")
    private Integer prodSize;

    @Column(name = "prod_status")
    private Boolean prodStatus;

    @Column(name = "prod_release_date")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date prodReleaseDate;

    @Column(name = "process_user")
    private String processUser;

    @Column(name = "last_update_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date lastUpdateTime;
}
