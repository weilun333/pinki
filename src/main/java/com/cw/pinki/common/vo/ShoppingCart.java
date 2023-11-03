package com.cw.pinki.common.vo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode
@Entity
@IdClass(ShoppingCartId.class)
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @Column(name = "member_no")
    private Integer memberNo;

    @Id
    @Column(name = "prod_no")
    private Integer prodNo;

    @Column(name = "prod_qty")
    private Integer prodQty;
}

@EqualsAndHashCode
@AllArgsConstructor
class ShoppingCartId implements Serializable {
    private Integer memberNo;
    private Integer prodNo;
}
