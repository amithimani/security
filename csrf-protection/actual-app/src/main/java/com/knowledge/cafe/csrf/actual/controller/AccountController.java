package com.knowledge.cafe.csrf.actual.controller;

import com.knowledge.cafe.csrf.actual.model.Transfer;
import com.knowledge.cafe.csrf.actual.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    /**
     * This is a representative operation for demonstrating CSRF.
     *
     * To execute this method, you need to be authenticated. However, anohter site make
     * you send request to this handler and you may not be aware of it. You may click
     * a button, or an image so you will be the sender. The operation will be executed,
     * because this actual application will think you are the sender and you are authenticated.
     *
     * @return
     */
    @GetMapping
    public String transferMoney(Transfer transfer) {
        return "fund-transfer";
    }

    @PostMapping("/transfer")
    public String transferFund(@Valid Transfer transfer, Model model) {
        accountService.doTransfer(transfer);
        return "success";
    }

    @GetMapping("/transferhistory")
    public String getTransferHistory(Model model) {
        model.addAttribute("transferList", accountService.getTransferHistory());
        return "transfer-history";
    }
}
