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
@IdClass(CollectedDesignerId.class)
@Table(name = "collected_designer")
public class CollectedDesigner {
    @Id
    @Column(name = "member_no")
    private Integer memberNo;

    @Id
    @Column(name = "brand_no")
    private Integer brandNo;
}

@EqualsAndHashCode
@AllArgsConstructor
class CollectedDesignerId implements Serializable {
    private Integer memberNo;
    private Integer brandNo;

}
