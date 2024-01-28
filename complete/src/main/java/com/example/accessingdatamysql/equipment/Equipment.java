package com.example.accessingdatamysql.equipment;

import com.example.accessingdatamysql.equipment_type.EquipmentType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipment_type_id")
    private EquipmentType equipmentType;
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
