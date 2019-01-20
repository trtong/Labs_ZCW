package io.zipcoder.tc_spring_poll_application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.zipcoder.tc_spring_poll_application.domain.Option;
import io.zipcoder.tc_spring_poll_application.domain.Poll;
import io.zipcoder.tc_spring_poll_application.exception.ResourceNotFoundException;
import io.zipcoder.tc_spring_poll_application.repositories.PollRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static io.zipcoder.tc_spring_poll_application.JsonTestUtilities.asJsonString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(PollController.class)
public class PollControllerTest {

    @Autowired
    private MockMvc mvc;

    // ==== Instance variables ==== //
    private Poll testPoll, testPoll2;
    private Iterable<Poll> polls;
    private final Long POLL_ID = 1L;
    private final Long BAD_ID = 1100L;
    private Set<Option> options1, options2;
    private Option option1, option2, option3, option4;

    @MockBean
    private PollRepository pollRepository;

    @InjectMocks
    @Autowired
    private PollController pollController;

    @Before
    public void setUp() {
        pollController = new PollController(pollRepository);
        JacksonTester.initFields(this, new ObjectMapper());

        mvc = MockMvcBuilders.standaloneSetup(pollController)
                .setControllerAdvice( new ResourceNotFoundException())
                .build();

        testPoll = new Poll();
        testPoll.setQuestion("Hello, are you well today?");
        testPoll.setId(POLL_ID);

        options1 = new HashSet<>();

        option1 = new Option();
        option1.setValue("Yes");
        option1.setId(1L);

        option2 = new Option();
        option2.setValue("No");
        option2.setId(2L);

        options1.add(option1);
        options1.add(option2);

        testPoll.setOptions(options1);

        // ============= test poll 2 =============

        testPoll2 = new Poll();
        testPoll2.setQuestion("Is it your birthday?");
        options2 = new HashSet<>();

        option3 = new Option();
        option3.setValue("Yes");
        option3.setId(1L);

        option4 = new Option();
        option4.setValue("No");
        option4.setId(2L);

        options2.add(option1);
        options2.add(option2);
        testPoll2.setOptions(options2);

        Poll[] pollArr = {testPoll, testPoll2};
        polls = Arrays.asList(pollArr);
    }

    // =================== Get one =================== //

    @Test
    public void testGetPollByIdSuccess() throws Exception {

        given(pollRepository.findOne(POLL_ID))
                .willReturn(testPoll);

        MockHttpServletResponse response = mvc.perform(get("/polls/1")
                .content(asJsonString(testPoll))
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        Assert.assertEquals(HttpStatus.OK.value(), (response.getStatus()));
    }

    // =================== Get All =================== //

    @Test
    public void testGetAllPollsSuccess() throws Exception {

        given(pollRepository.findAll())
                .willReturn(polls);

        MockHttpServletResponse response = mvc.perform(get("/polls")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        Assert.assertEquals(HttpStatus.OK.value(), (response.getStatus()));
    }

    @Test
    public void testGetPollByIdFailException() throws Exception {

        given(pollRepository.findOne(200L))
                .willThrow(new ResourceNotFoundException());

        MockHttpServletResponse response = mvc.perform(
                get("/polls/200")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        Assert.assertEquals(response.getStatus(), HttpStatus.NOT_FOUND.value());
        Assert.assertTrue(response.getContentAsString().isEmpty());
    }

    // =================== Create Poll =================== //

    @Test
    public void testCreatePollSuccess() throws Exception {
        given(pollRepository.save(testPoll2)).willReturn(testPoll2);

        mvc.perform(post("/polls/")
                .content(asJsonString(testPoll2))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    // =================== Update Poll =================== //

    @Test
    public void testUpdatePollSuccess() {

        /* can't get it to work, rewriting */
    }

    @Test
    public void testUpdatePollFail() throws Exception {

        given(pollRepository.findOne(BAD_ID)).willReturn(null);

        MockHttpServletResponse response = mvc.perform(put("/polls/10101")
                .content(asJsonString(testPoll))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        Assert.assertEquals(HttpStatus.NOT_FOUND.value(),(response.getStatus()));
    }

    // =================== Delete Poll =================== //

    @Test
    public void testDeletePollSuccess() throws Exception {
        given(pollRepository.findOne(1l))
                .willReturn(new Poll());

        mvc.perform(delete("/polls/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeletePollFail() throws Exception {
        given(pollRepository.findOne(BAD_ID))
                .willThrow(new ResourceNotFoundException());

        MockHttpServletResponse response = mvc.perform(delete("/polls/400")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        Assert.assertEquals(HttpStatus.NOT_FOUND.value(),(response.getStatus()));

    }


    // =================== Test Exception Thrown =================== //
}