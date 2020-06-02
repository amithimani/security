package com.knowledge.cafe.rt.repository;

import com.knowledge.cafe.rt.entity.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long>, FeedbackRepositoryCustom {

    @Override
    List<Feedback> findAll();

    @Override
    Feedback save(Feedback feedback);
}
