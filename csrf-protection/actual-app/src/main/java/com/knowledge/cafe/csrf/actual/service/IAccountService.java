package com.knowledge.cafe.csrf.actual.service;

import com.knowledge.cafe.csrf.actual.model.Transfer;

import java.util.Collection;

public interface IAccountService {

    Transfer doTransfer(Transfer transfer);

    Collection<Transfer> getTransferHistory();
}
