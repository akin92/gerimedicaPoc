package com.logicbig.example.repository;

import com.logicbig.example.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data,Integer> {
    Data findByCode(String code);
}
