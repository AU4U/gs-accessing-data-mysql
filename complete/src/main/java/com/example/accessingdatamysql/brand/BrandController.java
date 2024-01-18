package com.example.accessingdatamysql.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/brand")
public class BrandController {
    @Autowired
    private BrandRepository brandRepository;
    @PostMapping(path="/add")
    public @ResponseBody String addBrand(@RequestParam String name){
        Brand b = new Brand();
        b.setName(name);
        brandRepository.save(b);
        return "Saved";
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Brand> getAllBrand(){
        return brandRepository.findAll();
    }

}
