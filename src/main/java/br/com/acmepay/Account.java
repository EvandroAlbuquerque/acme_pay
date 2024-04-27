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

    public void deposit(BigDecimal amount) {
        this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws BalanceToWithdrawException {
        if (this.balance.compareTo(amount) >= 0) {
            this.balance.subtract(amount);
        } else {
           throw new BalanceToWithdrawException("Money is not enough");
        }
    }

    public void transfer(BigDecimal amount, Account destinyAccount) throws BalanceToWithdrawException {
        BigDecimal actualBalances = new BigDecimal(BigInteger.ZERO);
        actualBalances.add(this.getBalance());
        actualBalances.add(destinyAccount.getBalance());

        if (this.balance.compareTo(amount) >= 0) {
            this.balance.subtract(amount);
            destinyAccount.balance.add(amount);

            BigDecimal newBalances = new BigDecimal(BigInteger.ZERO);
            newBalances.add(this.getBalance());
            newBalances.add(destinyAccount.getBalance());

            if (actualBalances.compareTo(newBalances) != 0) {
                throw new BalanceToWithdrawException("Money is not enough");
            }
        } else {
            throw new BalanceToWithdrawException("Money is not enough");
        }
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
