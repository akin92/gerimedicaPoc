package com.logicbig.example.service;

import com.logicbig.example.model.Data;
import com.logicbig.example.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    @Autowired
    DataRepository dataRepository;


    public void saveAllData(List<Data> dataList) {
        dataRepository.saveAll(dataList);
    }

    public Data saveData(Data data) {
        return dataRepository.save(data);
    }

    public List<Data> findAllData() {
        return dataRepository.findAll();
    }

    public void deleteAllData() {
        dataRepository.deleteAll();
    }

    public Data findByCodeData(String code) {
       return dataRepository.findByCode(code);
    }
}
