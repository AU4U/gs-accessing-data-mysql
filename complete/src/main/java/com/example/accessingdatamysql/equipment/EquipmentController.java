package com.example.accessingdatamysql.equipment;

import com.example.accessingdatamysql.brand.Brand;
import com.example.accessingdatamysql.brand.BrandRepository;
import com.example.accessingdatamysql.connect_pint_type.ConnectPintType;
import com.example.accessingdatamysql.connect_pint_type.ConnectPintTypeRepository;
import com.example.accessingdatamysql.equipment_type.EquipmentType;
import com.example.accessingdatamysql.equipment_type.EquipmentTypeRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 设备
 */
@Controller
//@RequestMapping(path = "/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private EquipmentTypeRepository equipmentTypeRepository;
    @Autowired
    private ConnectPintTypeRepository connectPintTypeRepository;
    @Autowired
    private BrandRepository brandRepository;
    /**
     * 创建设备
     * @param newEquipment 设备
     * @return Equipment 设备
     */
    @PostMapping(path = "/equipments")
public @ResponseBody String create(@RequestBody @NotNull Equipment newEquipment) {
        EquipmentType existingEquipmentType = equipmentTypeRepository.findById(newEquipment.getEquipmentType().getId())
                .orElseThrow(() -> new RuntimeException("EquipmentType with id " + newEquipment.getEquipmentType().getId() + " does not exist"));
        newEquipment.setEquipmentType(existingEquipmentType);
        ConnectPintType existingConnectPintType = connectPintTypeRepository.findById(newEquipment.getConnectPintType().getId())
                .orElseThrow(() -> new RuntimeException("ConnectPintType with id " + newEquipment.getConnectPintType().getId() + " does not exist"));
        newEquipment.setConnectPintType(existingConnectPintType);
        equipmentRepository.save(newEquipment);
        return "Saved";
    }

    /**
     * 获取所有设备
     * @return Iterable<Equipment> 设备列表
     */
    @GetMapping(path = "/equipments")
    public @ResponseBody Iterable<Equipment> all() {
        return equipmentRepository.findAll();
    }

    /**
     * 获取指定id的设备
     * @param id 设备id
     * @return Equipment 设备
     */
    @GetMapping(path = "/equipments/{id}")
    public @ResponseBody Equipment one(@PathVariable int id) {
        return equipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("not found equipment by " + id));
    }

    /**
     * 删除指定id的设备
     * @param id 设备id
     * @return ResponseEntity<?>
     */
    @DeleteMapping(path = "/equipments/{id}")
    public @ResponseBody ResponseEntity<?> delete(@PathVariable int id) {
        equipmentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 更新指定id的设备
     * @param id 设备id
     * @param newEquipment 设备
     * @return 设备
     */
    @PutMapping(path = "/equipments/{id}")
    public Equipment update(@PathVariable int id, @RequestBody Equipment newEquipment) {
        return equipmentRepository.findById(id)
                .map(equipment -> {
                    BeanUtils.copyProperties(newEquipment,equipment,"id");
                    return equipmentRepository.save(equipment);
                })
                .orElseGet(() -> {
                    newEquipment.setId(id);
                    return equipmentRepository.save(newEquipment);
                });
    }
}
