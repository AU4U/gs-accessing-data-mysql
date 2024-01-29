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
    /**
     * 设备id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    /**
     * 设备类型
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipment_type_id")
    private EquipmentType equipmentType;
    /**
     * 连接点类型
     */
    private String connectPintType;
    /**
     * 焊接钳类型
     */
    private String weldingTongType;
    /**
     * 品牌
     */
    private String brand;
    /**
     * 设备型号
     */
    private String equipmentModel;
    /**
     * 图片
     */
    private String img;
    /**
     * 模型文件
     */
    private String modelFile;
    /**
     * 喉深A
     */
    private Integer a;
    /**
     * 喉宽B
     */
    private Integer b;
    /**
     * 开口大小C
     */
    private Integer c;
    /**
     * 下臂高度D
     */
    private Integer d;
    /**
     * E值
     */
    private String e;
    /**
     * 上市日期
     */
    private String listingDate;
    /**
     * 是否停产
     */
    private Boolean stopProduction;
}
