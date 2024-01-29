package com.example.accessingdatamysql.brand;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * 品牌VO
 */
@Setter
@Getter
@Entity
public class Brand {
    /**
     * 品牌id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Integer id;
    /**
     * 品牌名称
     */
    private String value;

}
