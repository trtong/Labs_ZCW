package io.zipcoder.tc_spring_poll_application.controller;

import io.zipcoder.tc_spring_poll_application.repositories.VoteRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ComputeResultControllerTest {

    private ComputeResultController computeResultController;

    @Autowired
    private MockMvc mvc;

    @Mock
    private VoteRepository voteRepository;

    @Before
    public void setUp(){
        computeResultController = new ComputeResultController(voteRepository);
    }

    @Test
    public void testComputeResults() {

    }
}
