package com.example.accessingdatamysql.equipment_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller    // This means that this class is a Controller
public class EquipmentTypeController {
    @Autowired
    private EquipmentTypeRepository equipmentTypeRepository;

    @PostMapping(path = "/equipmentType")
    public @ResponseBody EquipmentType newEquipmentType(@RequestBody EquipmentType newEquipmentType) {
        return equipmentTypeRepository.save(newEquipmentType);
    }

    @GetMapping(path = "/equipmentType")
    public @ResponseBody Iterable<EquipmentType> all() {
        return equipmentTypeRepository.findAll();
    }

    @GetMapping(path = "/equipmentType/{id}")
    public @ResponseBody EquipmentType one(@PathVariable int id) {
        return equipmentTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("not found EquipmentType by " + id));
    }

    @DeleteMapping(path = "/equipmentType/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if(!equipmentTypeRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        equipmentTypeRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

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
