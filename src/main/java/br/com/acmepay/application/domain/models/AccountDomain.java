package br.com.acmepay.application.domain.models;

import br.com.acmepay.application.domain.exception.BalanceToWithdrawException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccountDomain {

    private Long id;

    private Integer number;

    private Integer agency;

    private BigDecimal balance;

    private CustomerDomain customerDomain;

    private List<CardDomain> cardDomains;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    private Boolean closed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CardDomain> getCards() {
        return cardDomains;
    }

    public void setCards(List<CardDomain> cardDomains) {
        this.cardDomains = cardDomains;
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

    public CustomerDomain getCustomer() {
        return customerDomain;
    }

    public void setCustomer(CustomerDomain customerDomain) {
        this.customerDomain = customerDomain;
    }

    private List<String> transactions = new ArrayList<>();

    public void create(AccountDomain accountDomain) {
        this.setId(accountDomain.getId());
        this.setCreated_at(LocalDateTime.now());
        this.setUpdated_at(null);
        this.setCustomer(createCustomer(new CustomerDomain()));
        this.setCards(new ArrayList<>());
        this.setNumber(accountDomain.getNumber());
        this.setAgency(accountDomain.getAgency());
        this.setClosed(accountDomain.isClosed());
        this.transactions.add("Account created: " + LocalDateTime.now().toString());
    }

    public boolean hasEnoughBalance(BigDecimal amount) {
        return this.balance.compareTo(amount) >= 0;
    }

    public void deposit(BigDecimal amount) {
        this.balance.add(amount);
        this.transactions.add("Deposit done of " + amount.toString() + ": " + LocalDateTime.now().toString());
    }

    public void withdraw(BigDecimal amount) throws BalanceToWithdrawException {
        if (hasEnoughBalance(amount)) {
            this.balance.subtract(amount);
            this.transactions.add("Withdraw done of " + amount.toString() + ": " + LocalDateTime.now().toString());
        } else {
            this.transactions.add("Error on withdraw of " + amount.toString() + ": " + LocalDateTime.now().toString());
            throw new BalanceToWithdrawException("Money is not enough");
        }
    }

    public void transfer(BigDecimal amount, AccountDomain destinyAccountDomain) throws BalanceToWithdrawException {
        this.withdraw(amount);
        destinyAccountDomain.deposit(amount);
        this.transactions.add("Transfer done of" + amount.toString() +" from account " + this.number.toString() + " to account " + destinyAccountDomain.number.toString() + ": " + LocalDateTime.now().toString());
    }

    private CustomerDomain createCustomer(CustomerDomain customerDomain) {
        customerDomain.setId(customerDomain.getId());
        customerDomain.setName(customerDomain.getName());
        customerDomain.setEmail(customerDomain.getEmail());
        customerDomain.setPhone(customerDomain.getPhone());
        customerDomain.setDocument(customerDomain.getDocument());

        return customerDomain;
    }
}
