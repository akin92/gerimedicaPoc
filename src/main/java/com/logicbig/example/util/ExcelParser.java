package com.logicbig.example.util;

import com.logicbig.example.model.Data;
import com.logicbig.example.service.DataService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;


@Service
public class ExcelParser {

    private static final Logger logger = LogManager.getLogger(ExcelParser.class);



    @Autowired
    DataService dataService;

    @Transactional
    public void parse() {

        String line;
        String splitBy = ",";
        int index = 0;
        List<Data> dataList = new ArrayList<>();
        InputStream is;
        try {
                is = getFileFromResourceAsStream("exercise.csv");

//parsing a CSV file into BufferedReader class constructor
            InputStreamReader streamReader =
                    new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(streamReader);
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                if (index == 0) {
                    index++;
                    continue;
                }
                String[] object = line.split(splitBy);    // use comma as separator
                saveDataToDb(dataList, object);
                index++;
            }
            dataService.saveAllData(dataList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }

    private void saveDataToDb(List<Data> dataList, String[] object) {
        logger.info("Data [source=" + object[0] + ", codeListCode=" + object[1] + ", code=" + object[2] +
                ", displayValue=" + object[3] + ", longDesc=" + object[4] + ", fromDate=" + object[5] + ", toDate=" + object[6] +  ", sortingPrio=" + object[7] + "]");

        dataList.add(new Data(object[0].replace("\"", ""),object[1].replace("\"", ""),object[2].replace("\"", ""), object[3].replace("\"", ""),
                object[4].replace("\"", ""),  object[5].replace("\"", ""), object[6] ,object[7].replace("\"", "") ));


    }

}
