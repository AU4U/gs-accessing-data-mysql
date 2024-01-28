package com.example.accessingdatamysql.equipment_type;

import com.example.accessingdatamysql.equipment.Equipment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
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
    private List<Equipment> equipments;
}
