package com.knowledge.cafe.csrf.actual.repository;

import com.knowledge.cafe.csrf.actual.model.Transfer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundTransferRepository extends CrudRepository<Transfer, Long> {
}
