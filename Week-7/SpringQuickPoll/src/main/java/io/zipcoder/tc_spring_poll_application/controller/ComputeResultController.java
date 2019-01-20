package io.zipcoder.tc_spring_poll_application.controller;

import io.zipcoder.tc_spring_poll_application.domain.Vote;
import io.zipcoder.tc_spring_poll_application.dtos.OptionCount;
import io.zipcoder.tc_spring_poll_application.dtos.VoteResult;
import io.zipcoder.tc_spring_poll_application.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.stream.StreamSupport;

@RestController
public class ComputeResultController {

    private VoteRepository voteRepository;

    @Autowired
    public ComputeResultController(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @RequestMapping(value = "/computeresult", method = RequestMethod.GET)
    public ResponseEntity<?> computeResult(@RequestParam Long pollId) {
        VoteResult voteResult = new VoteResult();
        Iterable<Vote> allVotes = voteRepository.findVotesByPoll(pollId);

        long voteCount = StreamSupport.stream(allVotes.spliterator(), false).count();
        HashMap<Long, OptionCount> optionCountsMap = new HashMap<>();

        for (Vote v: allVotes) {
            Long optionID = (v.getOption().getId());
            OptionCount temp;
            if (!optionCountsMap.keySet().contains(optionID)) {
                temp = new OptionCount();
                temp.setOptionId(optionID);
                temp.setCount(1);
                optionCountsMap.put(optionID,temp);
            } else {
                temp = optionCountsMap.get(optionID);
                temp.setCount(temp.getCount()+1);
                optionCountsMap.replace(optionID, temp);
            }
        }
        voteResult.setTotalVotes((int)voteCount);
        voteResult.setResults(optionCountsMap.values());

        return new ResponseEntity<>(voteResult, HttpStatus.OK);

    }
}
