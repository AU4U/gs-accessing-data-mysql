package com.example.accessingdatamysql.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller    // This means that this class is a Controller
public class BrandController {
    @Autowired
    private BrandRepository brandRepository;

    /**
     * 创建品牌
     * @param newBrand 品牌
     * @return
     */
    @PostMapping(path = "/brands")
    public @ResponseBody Brand newBrand(@RequestBody Brand newBrand) {
        return brandRepository.save(newBrand);
    }

    /**
     * 获取所有品牌
     * @return
     */
    @GetMapping(path = "/brands")
    public @ResponseBody Iterable<Brand> all() {
        return brandRepository.findAll();
    }

    /**
     * 获取指定id的品牌
     * @param id
     * @return
     */
    @GetMapping(path = "/brands/{id}")
    public @ResponseBody Brand one(@PathVariable int id) {
        return brandRepository.findById(id).orElseThrow(() -> new RuntimeException("not found brands by " + id));
    }

    /**
     * 删除指定id的品牌
     * @param id
     * @return
     */
    @DeleteMapping(path = "/brands/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if(!brandRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        brandRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 更新指定id的品牌
     * @param id
     * @param newBrand
     * @return
     */
    @PutMapping(path = "/brands/{id}")
    public Brand update(@PathVariable int id, @RequestBody Brand newBrand) {
        return brandRepository.findById(id)
                .map(brand -> {
                    brand.setValue(newBrand.getValue());
                    return brandRepository.save(brand);
                })
                .orElseGet(() -> {
                    newBrand.setId(id);
                    return brandRepository.save(newBrand);
                });
    }
}
