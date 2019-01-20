package com.example.bakerylab.controllers;

import com.example.bakerylab.models.Baker;
import com.example.bakerylab.repositories.BakerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Optional;

import static com.example.bakerylab.JsonUtil.asJsonString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(BakerController.class)
public class BakerControllerTest {

    // === Instance Variables === //
    private Baker froilan;
    private final String GOOD_URL = "/bakers";
    private final String BAD_URL = "/bakers500";

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

        froilan = new Baker("Froilan", "Master Baker", "Croissants");
        froilan.setId(1L);
    }

    // ================= Create Baker ================= //

    @Test
    public void testCreateBakerSuccess() throws Exception {

        given(bakerRepository.save(froilan)).willReturn(froilan);

        mvc.perform(post("/bakers")
            .content(asJsonString(froilan))
            .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void testCreateBakerFail() throws Exception {
        Baker b = new Baker ("Seth", "froilans prepper", "muffins");
        given(bakerRepository.save(b)).willReturn(b);

        mvc.perform(post(BAD_URL)
                .content(asJsonString(froilan))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    // ================= Get Baker ================= //

    @Test
    public void getBakerById() throws Exception {
        Long bakerId = 1L;
        given(bakerRepository.findById(bakerId)).willReturn(Optional.of(froilan));

        mvc.perform(get(GOOD_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getBakerIdFail() throws Exception {
        Long bakerId = 500L;
        given(bakerRepository.findById(bakerId)).willReturn(null);

        mvc.perform(get(GOOD_URL + "/{id}", bakerId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    // ================= Get Bakers ================= //

    @Test
    public void getAllBakersSuccess() throws Exception {
        ArrayList<Baker> bakers = new ArrayList<>();
        bakers.add(froilan);
        given(bakerRepository.findAll()).willReturn(bakers);

        mvc.perform(get(GOOD_URL))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllBakersFail() throws Exception {
        given(bakerRepository.findAll()).willReturn(null);

        mvc.perform(get(BAD_URL))
                .andExpect(status().isNotFound());
    }

    // ================= Update Baker ================= //

    @Test
    public void updateBakerSuccess() throws Exception {
        froilan.setId(500L);
        given(bakerRepository.findById(froilan.getId())).willReturn(Optional.ofNullable(froilan));


        mvc.perform(put("/bakers/{id}", froilan.getId())
                .content(asJsonString(froilan))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void updateBakerFail() throws Exception {
        froilan.setId(500L);
        given(bakerRepository.findById(froilan.getId())).willReturn(null);


        mvc.perform(put("/bakers/{id}", froilan.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(froilan)))
                .andExpect(status().isNotFound());
    }

    // ================= Delete Baker ================= //

    @Test
    public void deleteBakerSuccess() throws Exception {
        given(bakerRepository.findById(froilan.getId()))
                .willReturn(Optional.ofNullable(froilan));

        mvc.perform(delete("/bakers/{id}", froilan.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteBakerFail() throws Exception {
        given(bakerRepository.findById(froilan.getId()))
                .willReturn(null);

        mvc.perform(delete("bakers/{id}", froilan.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}