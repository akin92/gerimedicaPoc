package com.logicbig.example.controller;

import com.logicbig.example.model.*;
import com.logicbig.example.service.DataService;
import com.logicbig.example.util.ExcelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiController {


    @Autowired
    ExcelParser excelParser;

    @Autowired
    DataService dataService;

    @PostConstruct
    public void fillTables() {
        excelParser.parse();
    }

    @GetMapping("/data")
    public ResponseEntity<List<Data>> getAllData() {
        try {
            List<Data> listing = new ArrayList<>(dataService.findAllData());

            if (listing.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(listing, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/data")
    @ResponseBody
    public ResponseEntity<Data> saveData(@RequestBody Data data) {
        try {
            Data savedData = dataService.saveData(data);
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new ResponseError("Duplicate data adding error","you can not add  data by using same code. Code have to be unique"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/dataByCode/{code}")
    public ResponseEntity<Data> getDataByCode(@PathVariable("code") String code) {
        try {
            Data data = dataService.findByCodeData(code);

            if (data == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/data")
    public ResponseEntity<Void> deleteAllData() {
        try {
            dataService.deleteAllData();

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
