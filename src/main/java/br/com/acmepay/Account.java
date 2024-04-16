package br.com.acmepay;

import java.math.BigDecimal;

public class Account {

    private Integer AccountNumber;

    private Integer AgencyNumber;

    private BigDecimal balance;


    public Integer getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        AccountNumber = accountNumber;
    }

    public Integer getAgencyNumber() {
        return AgencyNumber;
    }

    public void setAgencyNumber(Integer agencyNumber) {
        AgencyNumber = agencyNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
