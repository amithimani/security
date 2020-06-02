package com.knowledge.cafe.rt;

import com.knowledge.cafe.rt.entity.Feedback;
import com.knowledge.cafe.rt.service.FeedbackServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("/")
public class FeedbackController {

    @Autowired
    private FeedbackServiceImp feedbackServiceImp;

    @GetMapping("/greet/{name}")
    public String getGreeting(@PathVariable(value ="name") String name) throws InterruptedException {
        Thread.sleep(5000);
        return "Hello " + name;
    }

    @GetMapping("feedback/list")
    public List<Feedback> getFeedbackList() {
        return feedbackServiceImp.getAllFeedback();
    }

    @PostMapping("feedback/submit")
    public Feedback submitFeedback(@RequestBody Feedback feedback) throws InterruptedException {
        synchronized (feedbackServiceImp) {
            Thread.sleep(5000);
            return feedbackServiceImp.submitFeedback(feedback);
        }
    }

    @GetMapping("feedback/{userId}")
    public List<Feedback> getFeedback(@PathVariable("userId") String userId) {
        return feedbackServiceImp.getFeedbackByuserId(userId);
    }

}
