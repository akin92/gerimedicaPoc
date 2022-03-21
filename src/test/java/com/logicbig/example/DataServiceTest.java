package com.logicbig.example;

import com.logicbig.example.model.*;
import com.logicbig.example.repository.DataRepository;
import com.logicbig.example.service.DataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class DataServiceTest {

    @Autowired
    public DataService dataService;

    @MockBean
    public DataRepository dataRepository;


    List<Object[]> contacts;
    Object[] contactsObject;

    List<Object[]> makeDistributions;
    Object[] distrbitons;

    String date;

    @TestConfiguration
    static class AutoScoutServiceIntegrationTestContextConfiguration {

        @Bean
        public DataService dataService() {
            return new DataService();
        }
    }

    @Before
    public void setUp() {
        date = "2020-01";
        contacts = new ArrayList<>();
        contactsObject = new Object[5];

        contactsObject[0] = 1000;
        contactsObject[1] = "BMW";
        contactsObject[2] = 3500;
        contactsObject[3] = 25000;
        contactsObject[4] = 15;
        contacts.add(contactsObject);

        makeDistributions = new ArrayList<>();
        distrbitons = new Object[2];
        distrbitons[0] = "BMW";
        distrbitons[1] = 10;
        makeDistributions.add(distrbitons);
    }

    @Test
    public void testGetAllListing() {
        List<Data> dataList = Mockito.mock(ArrayList.class);
        Mockito.when(dataService.findAllData()).thenReturn(dataList);

    }

    @Test
    public void testSaveSellerType() {
        Data data = new Data();
        data.setId(1);
        data.setCode("akin");
        Mockito.when(dataService.saveData(data)).thenReturn(data);

    }



}
