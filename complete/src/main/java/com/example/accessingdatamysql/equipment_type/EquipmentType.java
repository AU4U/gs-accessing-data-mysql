package com.example.accessingdatamysql.equipment_type;

import com.example.accessingdatamysql.equipment.Equipment;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String value;
    @OneToMany(mappedBy = "equipmentType")
    private List<Equipment> equipments;
}
