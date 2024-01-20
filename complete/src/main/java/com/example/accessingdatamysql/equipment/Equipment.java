package com.example.accessingdatamysql.equipment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * 设备信息
 */

@Setter
@Getter
@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String connectPintType;
    private String weldingTongType;
    private String brand;
    private String type;
    private String img;
    private String model;
    private Integer a;
    private Integer b;
    private Integer c;
    private Integer d;
    private String e;
    private String listingDate;
    private Boolean stopProduction;
}
