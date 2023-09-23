package com.cw.pinki.common.vo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "prod_label")
public class ProdLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_label_no")
    private Integer prodLabelNo;

    @Column(name = "brand_no")
    private Integer BrandNo;

    @Column(name = "prod_label_name")
    private String ProdLabelName;
}
