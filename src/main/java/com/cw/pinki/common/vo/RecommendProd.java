package com.cw.pinki.common.vo;

import jakarta.persistence.*;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "recommend_prod")
public class RecommendProd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recommend_prod_no")
    private Integer recommendProdNo;

    @Column(name = "prod_no")
    private Integer prodNo;

}
