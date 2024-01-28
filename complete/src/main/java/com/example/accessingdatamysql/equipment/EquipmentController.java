package com.example.accessingdatamysql.equipment;

import com.example.accessingdatamysql.brand.Brand;
import com.example.accessingdatamysql.equipment_type.EquipmentType;
import com.example.accessingdatamysql.equipment_type.EquipmentTypeRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping(path = "/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private EquipmentTypeRepository equipmentTypeRepository;


    @PostMapping(path = "/equipments")
public @ResponseBody String create(@RequestBody @NotNull Equipment newEquipment) {
    EquipmentType existingEquipmentType = equipmentTypeRepository.findById(newEquipment.getEquipmentType().getId())
            .orElseThrow(() -> new RuntimeException("EquipmentType with id " + newEquipment.getEquipmentType().getId() + " does not exist"));
    newEquipment.setEquipmentType(existingEquipmentType);
    equipmentRepository.save(newEquipment);
    return "Saved";
}

    @GetMapping(path = "/equipments")
    public @ResponseBody Iterable<Equipment> all() {
        return equipmentRepository.findAll();
    }
    @GetMapping(path = "/equipments/{id}")
    public @ResponseBody Equipment one(@PathVariable int id) {
        return equipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("not found equipment by " + id));
    }

    @DeleteMapping(path = "/equipments/{id}")
    public @ResponseBody ResponseEntity<?> delete(@PathVariable int id) {
        equipmentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

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
