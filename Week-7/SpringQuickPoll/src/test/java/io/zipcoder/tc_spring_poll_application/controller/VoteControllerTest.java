package io.zipcoder.tc_spring_poll_application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.zipcoder.tc_spring_poll_application.domain.Option;
import io.zipcoder.tc_spring_poll_application.domain.Poll;
import io.zipcoder.tc_spring_poll_application.domain.Vote;
import io.zipcoder.tc_spring_poll_application.exception.ResourceNotFoundException;
import io.zipcoder.tc_spring_poll_application.repositories.PollRepository;
import io.zipcoder.tc_spring_poll_application.repositories.VoteRepository;
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

import static io.zipcoder.tc_spring_poll_application.JsonTestUtilities.asJsonString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(VoteController.class)
public class VoteControllerTest {

    @Autowired
    private MockMvc mvc;

    private Vote testVote;
    private Iterable<Vote> votes;
    private final Long TEST_ID = 1L;
    private Option option1, option2;
    private HashSet<Option> options1;

    @MockBean
    private VoteRepository voteRepository;

    @MockBean
    private PollRepository pollRepository;

    @InjectMocks
    @Autowired
    private VoteController voteController;

    private Poll testPoll;

    @Before
    public void setUp() {

        voteController = new VoteController(voteRepository);
        JacksonTester.initFields(this, new ObjectMapper());

        mvc = MockMvcBuilders.standaloneSetup(voteController)
                .setControllerAdvice(new ResourceNotFoundException())
                .build();

        testVote = new Vote();
        testVote.setId(TEST_ID);

        Vote[] votearr = {testVote};
        votes = Arrays.asList(votearr);

        testPoll = new Poll();
        testPoll.setId(TEST_ID);

        testPoll.setQuestion("Do you like cheese?");
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
    }

    @Test
    public void testGetVotePollIdSuccess() throws Exception {

        given(voteRepository.findVotesByPoll(TEST_ID))
                .willReturn(votes);

        MockHttpServletResponse response = mvc.perform(get("/polls/1/votes")
                .content(asJsonString(votes))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
        Assert.assertEquals(response.getContentAsString(), votes.toString());
    }

    @Test
    public void testGetAllVotes() throws Exception {
        given(voteRepository.findAll())
                .willReturn(votes);

        MockHttpServletResponse response = mvc.perform(get("/polls/votes")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        Assert.assertEquals(response.getStatus(), HttpStatus.OK.value());
        Assert.assertEquals(response.getContentAsString(), votes.toString());
    }

    @Test
    public void testGetAllVotesFail() throws Exception {
        given(voteRepository.findAll())
                .willThrow(new ResourceNotFoundException());

        MockHttpServletResponse response = mvc.perform(
                get("/polls/votesBADBAD")
                    .accept(MediaType.APPLICATION_JSON))
                    .andReturn().getResponse();

        Assert.assertEquals(response.getStatus(), HttpStatus.NOT_FOUND.value());
        Assert.assertTrue(response.getContentAsString().isEmpty());
    }

    @Test
    public void testCreateVoteSuccess() throws Exception {
        Vote testVote2 = new Vote();
        testVote2.setId(TEST_ID);
        testVote2.setOption(option1);

        /* Fixed by adding an equals method and hashcode to each  object.
         * during mocking the 'save' method is checking the absolute equality
         * and since it's technically a different object, we have to override the equals method
         * to properly compare the objects. */

        given(pollRepository.findOne(TEST_ID)).willReturn(testPoll);
        given(voteRepository.save(testVote2)).willReturn(testVote2);

        mvc.perform(post("/polls/1/votes")
                .content(asJsonString(testVote2))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}
