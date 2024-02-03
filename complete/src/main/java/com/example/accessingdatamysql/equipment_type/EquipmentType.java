package com.example.accessingdatamysql.equipment_type;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 设备类型
 */
@Setter
@Getter
@Entity
public class EquipmentType {
    /**
     * 设备类型id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 设备类型名称
     */
    @ApiModelProperty(required = true)
    @NotNull
    private String value;
}
