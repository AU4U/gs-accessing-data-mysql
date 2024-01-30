package com.example.accessingdatamysql.welding_ton_type.brand;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * 焊接钳类型VO
 */
@Setter
@Getter
@Entity
public class WeldingTongType {
    /**
     * 焊接钳id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Integer id;
    /**
     * 焊接钳名称
     */
    private String value;

}
