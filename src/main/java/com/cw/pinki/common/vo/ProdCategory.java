package com.cw.pinki.common.vo;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "prod_category")
public class ProdCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_category_no")
    private Integer prodCategoryNo;

    @Column(name = "prod_category_name")
    private String prodCategoryName;
}
