package com.knowledge.cafe.rt.repository;

import com.knowledge.cafe.rt.entity.Feedback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class FeedbackRepositoryImpl implements FeedbackRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Feedback> findAllByuserId(String userId) {
        Query query = entityManager.createNativeQuery("select * from Feedback where user_id = " + userId, Feedback.class);
        return query.getResultList();
    }
}
