package com.knowledge.cafe.rt.repository;

import com.knowledge.cafe.rt.entity.Feedback;

import java.util.List;

public interface FeedbackRepositoryCustom {

    List<Feedback> findAllByuserId(String userId);
}
