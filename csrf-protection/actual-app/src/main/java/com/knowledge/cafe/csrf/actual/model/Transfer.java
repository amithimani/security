package com.knowledge.cafe.csrf.actual.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reference_id")
    private Long referenceId;

    @Column(name = "to_account")
    private String toAccount;

    @Column(name = "amount")
    private double amount;

    @Column(name = "transfer_date")
    private LocalDateTime transferDate;

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDateTime transferDate) {
        this.transferDate = transferDate;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "referenceId=" + referenceId +
                ", toAccount='" + toAccount + '\'' +
                ", amount=" + amount +
                ", transferDate=" + transferDate +
                '}';
    }
}
