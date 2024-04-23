package br.com.acmepay;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Account {

    private Long id;

    private Integer number;

    private Integer agency;

    private BigDecimal balance;

    private Customer customer;

    private List<Card> cards;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    private Boolean closed;


    public Integer getAccountNumber() {
        return number;
    }

    public void setAccountNumber(Integer accountNumber) {
        number = accountNumber;
    }

    public Integer getAgencyNumber() {
        return agency;
    }

    public void setAgencyNumber(Integer agencyNumber) {
        agency = agencyNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
