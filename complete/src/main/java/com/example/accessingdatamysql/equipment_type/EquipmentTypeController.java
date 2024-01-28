package com.example.accessingdatamysql.equipment_type;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 设备类型
 */
@Controller    // This means that this class is a Controller
public class EquipmentTypeController {
    @Autowired
    private EquipmentTypeRepository equipmentTypeRepository;

    /**
     * 创建设备类型
     * @param newEquipmentType 设备类型
     * @return
     */
    @PostMapping(path = "/equipmentType")
    public @ResponseBody EquipmentType create(@RequestBody @NotNull EquipmentType newEquipmentType) {
        return equipmentTypeRepository.save(newEquipmentType);
    }

    /**
     * 获取所有设备类型
     * @return
     */
    @GetMapping(path = "/equipmentType")
    public @ResponseBody Iterable<EquipmentType> all() {
        return equipmentTypeRepository.findAll();
    }

    /**
     * 获取指定id的设备类型
     * @param id 设备类型id
     * @return
     */
    @GetMapping(path = "/equipmentType/{id}")
    public @ResponseBody EquipmentType one(@PathVariable int id) {
        return equipmentTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("not found EquipmentType by " + id));
    }

    /*
     * 删除指定id的设备类型
     * @param id 设备类型id
     * @return
     */
//    @DeleteMapping(path = "/equipmentType/{id}")
//    public ResponseEntity<?> delete(@PathVariable int id) {
//        if(!equipmentTypeRepository.existsById(id)) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        equipmentTypeRepository.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    /**
     * 更新指定id的设备类型
     * @param id 设备类型id
     * @param newEquipmentType 设备类型
     * @return
     */
    @PutMapping(path = "/equipmentType/{id}")
    public EquipmentType update(@PathVariable int id, @RequestBody EquipmentType newEquipmentType) {
        return equipmentTypeRepository.findById(id)
                .map(equipmentType -> {
                    equipmentType.setValue(equipmentType.getValue());
                    return equipmentTypeRepository.save(newEquipmentType);
                })
                .orElseGet(() -> {
                    newEquipmentType.setId(id);
                    return equipmentTypeRepository.save(newEquipmentType);
                });
    }
}
