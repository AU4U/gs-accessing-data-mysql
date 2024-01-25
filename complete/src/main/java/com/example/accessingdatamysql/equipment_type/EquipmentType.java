package com.example.accessingdatamysql.equipment_type;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * 设备类型
 */
@Setter
@Getter
@Entity
public class EquipmentType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String value;
}
