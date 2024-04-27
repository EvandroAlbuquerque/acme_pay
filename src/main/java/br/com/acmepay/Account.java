package br.com.acmepay;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public Boolean isClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        number = number;
    }

    public Integer getAgency() {
        return agency;
    }

    public void setAgency(Integer agency) {
        agency = number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    private List<Account> accountsCreated = new ArrayList<>();

    public void create(Account account) {
        this.setId(account.getId());
        this.setCreated_at(LocalDateTime.now());
        this.setUpdated_at(null);
        this.setCustomer(createCustomer(new Customer()));
        this.setCards(new ArrayList<>());
        this.setNumber(account.getNumber());
        this.setAgency(account.getAgency());
        this.setClosed(account.isClosed());
        this.accountsCreated.add(this);
    }

    public boolean hasEnoughBalance(BigDecimal amount) {
        return this.balance.compareTo(amount) >= 0;
    }

    public void deposit(BigDecimal amount) {
        this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws BalanceToWithdrawException {
        if (hasEnoughBalance(amount)) {
            this.balance.subtract(amount);
        } else {
           throw new BalanceToWithdrawException("Money is not enough");
        }
    }

    public void transfer(BigDecimal amount, Account destinyAccount) throws BalanceToWithdrawException {
        this.withdraw(amount);
        destinyAccount.deposit(amount);
    }

    private Customer createCustomer(Customer customer) {
        customer.setId(customer.getId());
        customer.setName(customer.getName());
        customer.setEmail(customer.getEmail());
        customer.setPhone(customer.getPhone());
        customer.setDocument(customer.getDocument());

        return customer;
    }
}
