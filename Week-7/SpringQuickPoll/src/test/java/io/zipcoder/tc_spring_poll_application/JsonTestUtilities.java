package io.zipcoder.tc_spring_poll_application;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTestUtilities {
    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
