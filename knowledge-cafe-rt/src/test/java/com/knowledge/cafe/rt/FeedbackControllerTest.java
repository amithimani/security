package com.knowledge.cafe.rt;

import com.knowledge.cafe.rt.entity.Feedback;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class FeedbackControllerTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void getGreeting() {
        HttpHeaders httpHeaders = new HttpHeaders();
        Feedback feedback = new Feedback();
        feedback.setFeedbackComment("dummy feedback");
        feedback.setUserId("malicious");
        HttpEntity<Feedback> httpEntity = new HttpEntity<>(feedback, httpHeaders);
        IntStream.iterate(0, i -> i+1).parallel().forEach((i) -> {
            try {
                System.out.println("called " + 1);
                ResponseEntity<Feedback> responseEntity = restTemplate.postForEntity("http://localhost:7070/knowledgecafe/rt/feedback/submit", httpEntity, Feedback.class);
                System.out.println(responseEntity.getBody());
            } catch (Exception ex) {
                System.out.println("error.." + ex.getMessage());
            }
        });
    }
}