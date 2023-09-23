package com.cw.pinki.common.vo;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

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

    @UniqueElements(message = "商品類別重複")
    @Column(name = "prod_category_name")
    private String prodCategoryName;
}
