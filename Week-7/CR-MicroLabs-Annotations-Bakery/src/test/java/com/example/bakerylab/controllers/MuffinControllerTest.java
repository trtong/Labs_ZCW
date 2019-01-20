package com.example.bakerylab.controllers;

import com.example.bakerylab.models.Muffin;
import com.example.bakerylab.repositories.MuffinRepository;
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
@WebMvcTest(MuffinController.class)
public class MuffinControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    MuffinRepository muffinRepository;

    @InjectMocks
    @Autowired
    MuffinController muffinController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders
                .standaloneSetup(muffinController)
                .build();
    }

    // ================= Create Muffin ================= //

    // ================= Get Muffin ================= //

    // ================= Get Muffins ================= //

    // ================= Update Muffin ================= //

    // ================= Delete Muffin ================= //
}