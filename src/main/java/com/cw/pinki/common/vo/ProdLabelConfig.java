package com.cw.pinki.common.vo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "prod_label_config")
public class ProdLabelConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_label_config_no")
    private Integer prodLabelConfigNo;

    @Column(name = "brand_no")
    private Integer brandNo;

    @Column(name = "prod_label_name")
    private String prodLabelName;
}
