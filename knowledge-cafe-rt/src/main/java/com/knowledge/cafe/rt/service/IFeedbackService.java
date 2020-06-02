package com.knowledge.cafe.rt.service;

import com.knowledge.cafe.rt.entity.Feedback;

import java.util.List;

public interface IFeedbackService {

    List<Feedback> getAllFeedback();

    Feedback submitFeedback(Feedback feedback);

    List<Feedback> getFeedbackByuserId(String userId);

}
