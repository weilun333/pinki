package com.cw.pinki.common.vo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "prod_label")
public class ProdLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_label_no")
    private Integer prodLabelNo;

    @Column(name = "pro_label_config_no")
    private Integer prodLabelConfigNo;

    @Column(name = "prod_no")
    private String prodNo;
}
