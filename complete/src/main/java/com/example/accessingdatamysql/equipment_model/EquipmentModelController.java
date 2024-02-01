package com.example.accessingdatamysql.equipment_model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 设备型号类型
 */
@Controller    // This means that this class is a Controller
public class EquipmentModelController {
    @Autowired
    private EquipmentModelRepository equipmentModelRepository;

    /**
     * 创建品牌
     * @param newEquipmentModel 设备型号
     * @return EquipmentModel 设备型号
     */
    @PostMapping(path = "/equipmentModel")
    public @ResponseBody EquipmentModel create(@RequestBody EquipmentModel newEquipmentModel) {
        return equipmentModelRepository.save(newEquipmentModel);
    }

    /**
     * 获取所有设备型号
     * @return Iterable<EquipmentModel> 设备型号列表
     */
    @GetMapping(path = "/equipmentModel")
    public @ResponseBody Iterable<EquipmentModel> all() {
        return equipmentModelRepository.findAll();
    }

    /**
     * 获取指定id的设备型号
     * @param id 品牌id
     * @return 品牌
     */
    @GetMapping(path = "/equipmentModel/{id}")
    public @ResponseBody EquipmentModel one(@PathVariable int id) {
        return equipmentModelRepository.findById(id).orElseThrow(() -> new RuntimeException("not found equipmentModel by " + id));
    }

    /**
     * 删除指定id的设备型号
     * @param id 品牌id
     * @return ResponseEntity<?>
     */
    @DeleteMapping(path = "/equipmentModel/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if(!equipmentModelRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        equipmentModelRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 更新指定id的设备型号
     * @param id 设备型号id
     * @param newEquipmentModel 设备型号
     * @return 设备型号
     */
    @PutMapping(path = "/equipmentModel/{id}")
    public EquipmentModel update(@PathVariable int id, @RequestBody EquipmentModel newEquipmentModel) {
        return equipmentModelRepository.findById(id)
                .map(equipmentModel -> {
                    equipmentModel.setValue(newEquipmentModel.getValue());
                    return equipmentModelRepository.save(equipmentModel);
                })
                .orElseGet(() -> {
                    newEquipmentModel.setId(id);
                    return equipmentModelRepository.save(newEquipmentModel);
                });
    }
}
