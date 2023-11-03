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
@IdClass(CollectedProductId.class)
@Table(name = "collected_product")
public class CollectedProduct {
    @Id
    @Column(name = "member_no")
    private Integer memberNo;

    @Id
    @Column(name = "prod_no")
    private Integer prodNo;

}

@EqualsAndHashCode
@AllArgsConstructor
class CollectedProductId implements Serializable {
    private Integer memberNo;
    private Integer prodNo;
}
