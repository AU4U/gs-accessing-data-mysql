package com.example.accessingdatamysql.equipment;

import com.example.accessingdatamysql.brand.Brand;
import com.example.accessingdatamysql.connect_pint_type.ConnectPintType;
import com.example.accessingdatamysql.equipment_type.EquipmentType;
import com.example.accessingdatamysql.file.FileDTO;
import com.example.accessingdatamysql.welding_ton_type.brand.WeldingTongType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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
    @JdbcTypeCode(SqlTypes.JSON)
    private EquipmentType equipmentType;
    /**
     * 连接点类型
     */
    @JdbcTypeCode(SqlTypes.JSON)
    private ConnectPintType connectPintType;
    /**
     * 焊接钳类型
     */
    @JdbcTypeCode(SqlTypes.JSON)
    private WeldingTongType weldingTongType;
    /**
     * 品牌
     */
    @JdbcTypeCode(SqlTypes.JSON)
    private Brand brand;
    /**
     * 设备型号
     */
    @JdbcTypeCode(SqlTypes.JSON)
    private EquipmentType equipmentModel;
    /**
     * 图片
     */
    @JdbcTypeCode(SqlTypes.JSON)
    private FileDTO img;
    /**
     * 模型文件
     */
    @JdbcTypeCode(SqlTypes.JSON)
    private FileDTO modelFile;
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
