package com.example.accessingdatamysql.brand;

import com.example.accessingdatamysql.brand.Brand;
import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<Brand, Integer> {

}
