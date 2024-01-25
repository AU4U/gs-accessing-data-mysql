package com.example.accessingdatamysql.equipment_type;
import com.example.accessingdatamysql.brand.Brand;
import org.springframework.data.repository.CrudRepository;

public interface EquipmentTypeRepository extends CrudRepository<EquipmentType, Integer> {
}
