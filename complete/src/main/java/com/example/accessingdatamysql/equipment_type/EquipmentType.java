package com.example.accessingdatamysql.equipment_type;

import com.example.accessingdatamysql.equipment.Equipment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 设备类型
 */
@Setter
@Getter
@Entity
public class EquipmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ApiModelProperty(required = true)
    @NotNull
    private String value;
    @JsonIgnore
    @OneToMany(mappedBy = "equipmentType")
    @Nullable
    private List<Equipment> equipments;
}
