package com.example.accessingdatamysql.welding_ton_type.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 焊钳类型
 */
@Controller    // This means that this class is a Controller
public class WeldingTongTypeController {
    @Autowired
    private WeldingTongTypeRepository weldingTongTypeRepository;

    /**
     * 创建焊钳类型
     * @param newWeldingTongType 焊钳类型
     * @return Brand 焊钳类型
     */
    @PostMapping(path = "/weldingTongType")
    public @ResponseBody WeldingTongType create(@RequestBody WeldingTongType newWeldingTongType) {
        return weldingTongTypeRepository.save(newWeldingTongType);
    }

    /**
     * 获取所有焊钳类型
     * @return Iterable<Brand> 焊钳类型列表
     */
    @GetMapping(path = "/weldingTongType")
    public @ResponseBody Iterable<WeldingTongType> all() {
        return weldingTongTypeRepository.findAll();
    }

    /**
     * 获取指定id的焊钳类型
     * @param id 焊钳类型id
     * @return 焊钳类型
     */
    @GetMapping(path = "/weldingTongType/{id}")
    public @ResponseBody WeldingTongType one(@PathVariable int id) {
        return weldingTongTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("not found welding tong type by " + id));
    }

    /**
     * 删除指定id的焊钳类型
     * @param id 焊钳类型id
     * @return ResponseEntity<?>
     */
    @DeleteMapping(path = "/weldingTongType/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if(!weldingTongTypeRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        weldingTongTypeRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 更新指定id的焊钳类型
     * @param id 焊钳类型id
     * @param newWeldingTongType 焊钳类型
     * @return 焊钳类型
     */
    @PutMapping(path = "/weldingTongType/{id}")
    public WeldingTongType update(@PathVariable int id, @RequestBody WeldingTongType newWeldingTongType) {
        return weldingTongTypeRepository.findById(id)
                .map(weldingTongType -> {
                    weldingTongType.setValue(newWeldingTongType.getValue());
                    return weldingTongTypeRepository.save(weldingTongType);
                })
                .orElseGet(() -> {
                    newWeldingTongType.setId(id);
                    return weldingTongTypeRepository.save(newWeldingTongType);
                });
    }
}
