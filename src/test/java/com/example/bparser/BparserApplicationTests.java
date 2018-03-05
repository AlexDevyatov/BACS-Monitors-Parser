package com.example.bparser;

import com.example.bparser.model.ContestantData;
import com.example.bparser.service.ApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BparserApplicationTests {

    @Autowired
    private ApiService service;

    @Test
    public void contextLoads() {
    }

    @Test
    public void serviceTest() throws IOException {
        List<ContestantData> data = service.getContestData(1);
        assertEquals(data.size(), 23);
    }

}
