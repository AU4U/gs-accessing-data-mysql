package com.example.accessingdatamysql.equipment;

import com.example.accessingdatamysql.brand.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentRepository equipmentRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addBrand(
            @RequestParam String name,
            @RequestParam String connectPintType,
            @RequestParam String weldingTongType,
            @RequestParam String brand,
            @RequestParam String type,
            @RequestParam String img,
            @RequestParam String model,
            @RequestParam Integer a,
            @RequestParam Integer b,
            @RequestParam Integer c,
            @RequestParam Integer d,
            @RequestParam String e,
            @RequestParam String listingDate,
            @RequestParam Boolean stopProduction


    ) {
        Equipment equipment = new Equipment();
        equipment.setName(name);
        equipment.setConnectPintType(connectPintType);
        equipment.setWeldingTongType(weldingTongType);
        equipment.setBrand(brand);
        equipment.setType(type);
        equipment.setImg(img);
        equipment.setModel(model);
        equipment.setA(a);
        equipment.setB(b);
        equipment.setC(c);
        equipment.setD(d);
        equipment.setE(e);
        equipment.setListingDate(listingDate);
        equipment.setStopProduction(stopProduction);
        equipmentRepository.save(equipment);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Equipment> getAllBrand() {
        return equipmentRepository.findAll();
    }

}
