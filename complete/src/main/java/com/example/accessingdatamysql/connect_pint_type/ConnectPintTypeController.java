package com.example.accessingdatamysql.connect_pint_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 连接点类型
 */
@Controller
public class ConnectPintTypeController {
    @Autowired
    private ConnectPintTypeRepository connectPintTypeRepository;

    /**
     * 创建连接点类型
      * @param newConnectPintType 连接点类型
     * @return ConnectPintType 连接点类型
     */
    @PostMapping(path = "/connectPintType")
    public ConnectPintType create(ConnectPintType newConnectPintType) {
        return connectPintTypeRepository.save(newConnectPintType);
    }

    /**
     * 获取所有连接点类型
     * @return Iterable<ConnectPintType> 连接点类型列表
     */
    @GetMapping(path = "/connectPintType")
    public @ResponseBody Iterable<ConnectPintType> all() {
        return connectPintTypeRepository.findAll();
    }

    /**
     * 获取指定id的连接点类型
     * @param id 连接点类型id
     * @return ConnectPintType 连接点类型
     */
    @GetMapping(path = "/connectPintType/{id}")
    public @ResponseBody ConnectPintType one(Integer id) {
        return connectPintTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("not found ConnectPintType by " + id));
    }


}
