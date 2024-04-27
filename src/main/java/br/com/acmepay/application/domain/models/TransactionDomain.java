package br.com.acmepay.application.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionDomain {

    private UUID transactionId;

    private BigDecimal transactionValue;

    private AccountDomain destinationAccountDomain;

    private AccountDomain originAccountDomain;

    private LocalDateTime transactionDate;

    private UUID accountId;


    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(BigDecimal transactionValue) {
        this.transactionValue = transactionValue;
    }

    public AccountDomain getDestinationAccount() {
        return destinationAccountDomain;
    }

    public void setDestinationAccount(AccountDomain destinationAccountDomain) {
        this.destinationAccountDomain = destinationAccountDomain;
    }

    public AccountDomain getOriginAccount() {
        return originAccountDomain;
    }

    public void setOriginAccount(AccountDomain originAccountDomain) {
        this.originAccountDomain = originAccountDomain;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }
}
