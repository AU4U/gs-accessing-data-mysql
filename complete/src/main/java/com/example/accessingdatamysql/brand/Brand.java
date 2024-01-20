package com.example.accessingdatamysql.brand;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * 品牌消息
 */
@Setter
@Getter
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String value;

}
