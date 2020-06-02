package com.knowledge.cafe.rt.service;

import com.knowledge.cafe.rt.entity.Feedback;
import com.knowledge.cafe.rt.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FeedbackServiceImp implements IFeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback submitFeedback(Feedback feedback) {
        feedback.setSubmitDate(LocalDateTime.now());
        return feedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> getFeedbackByuserId(String userId) {
        return feedbackRepository.findAllByuserId(userId);
    }
}
