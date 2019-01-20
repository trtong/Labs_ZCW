package com.example.bakerylab.controllers;

import com.example.bakerylab.repositories.BakerRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@WebMvcTest(BakerController.class)
public class BakerControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    BakerRepository bakerRepository;

    @Autowired
    @InjectMocks
    BakerController bakerController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders
                .standaloneSetup(bakerController)
                .build();
    }


}