package com.example.accessingdatamysql.brand;

import com.example.accessingdatamysql.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 品牌类型
 */
@Controller    // This means that this class is a Controller
public class BrandController {
    @Autowired
    private BrandRepository brandRepository;

    /**
     * 创建品牌
     *
     * @param newBrand 品牌
     * @return Brand 品牌
     */
    @PostMapping(path = "/brands")
    public ResponseEntity<CommonResponse<Brand>> create(@RequestBody Brand newBrand) {
        try {
            Brand savedBrand = brandRepository.save(newBrand);
            CommonResponse<Brand> response = new CommonResponse<>(HttpStatus.CREATED.value(), "Brand created successfully", savedBrand);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            CommonResponse<Brand> response = new CommonResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An error occurred while creating the brand", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 获取所有品牌
     *
     * @return Iterable<Brand> 品牌列表
     */
    @GetMapping(path = "/brands")
    public ResponseEntity<CommonResponse<Iterable<Brand>>> all() {
        try {
            Iterable<Brand> brands = brandRepository.findAll();
            CommonResponse<Iterable<Brand>> response = new CommonResponse<>(HttpStatus.OK.value(), "Brands fetched successfully", brands);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            CommonResponse<Iterable<Brand>> response = new CommonResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An error occurred while fetching the brands", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    /**
//     * 获取指定id的品牌
//     *
//     * @param id 品牌id
//     * @return 品牌
//     */
//    @GetMapping(path = "/brands/{id}")
//    public @ResponseBody Brand one(@PathVariable int id) {
//        return brandRepository.findById(id).orElseThrow(() -> new RuntimeException("not found brands by " + id));
//    }

//    /**
//     * 删除指定id的品牌
//     *
//     * @param id 品牌id
//     * @return ResponseEntity<?>
//     */
//    @DeleteMapping(path = "/brands/{id}")
//    public ResponseEntity<?> delete(@PathVariable int id) {
//        if (!brandRepository.existsById(id)) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        brandRepository.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

//    /**
//     * 更新指定id的品牌
//     *
//     * @param id       品牌id
//     * @param newBrand 品牌
//     * @return 品牌
//     */
//    @PutMapping(path = "/brands/{id}")
//    public Brand update(@PathVariable int id, @RequestBody Brand newBrand) {
//        return brandRepository.findById(id).map(brand -> {
//            brand.setValue(newBrand.getValue());
//            return brandRepository.save(brand);
//        }).orElseGet(() -> {
//            newBrand.setId(id);
//            return brandRepository.save(newBrand);
//        });
//    }
}
