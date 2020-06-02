package com.knowledge.cafe.csrf.actual.service;

import com.knowledge.cafe.csrf.actual.model.Transfer;
import com.knowledge.cafe.csrf.actual.repository.FundTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private FundTransferRepository transferRepository;

    @Override
    public Transfer doTransfer(Transfer transfer) {
        transfer.setTransferDate(LocalDateTime.now());
        return transferRepository.save(transfer);
    }

    @Override
    public Collection<Transfer> getTransferHistory() {
        return (Collection<Transfer>) transferRepository.findAll();
    }
}
