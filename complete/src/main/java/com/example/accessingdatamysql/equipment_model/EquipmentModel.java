package com.example.accessingdatamysql.equipment_model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * 设备型号VO
 */
@Setter
@Getter
@Entity
public class EquipmentModel {
    /**
     * 设备型号id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Integer id;
    /**
     * 设备型号名称
     */
    private String value;

}
