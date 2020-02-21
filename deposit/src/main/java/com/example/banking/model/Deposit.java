package com.example.banking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long clientId;
    private String accountNumber;
    private String name;
    private double balance;

    public Deposit() {
    }

    public Deposit(long clientId, String accountNumber, String name, double balance){
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public static DepositBuilder builder() {
        return new DepositBuilder();
    }

    public static final class DepositBuilder {

        private Deposit deposit;

        private DepositBuilder() {
            deposit = new Deposit();
        }

        public DepositBuilder withId(Long id) {
            deposit.setId(id);
            return this;
        }

        public DepositBuilder withBalance(double balance) {
            deposit.setBalance(balance);
            return this;
        }
        public DepositBuilder withClientId(long clientId) {
            deposit.setClientId(clientId);
            return this;
        }
        public DepositBuilder withName(String name) {
            deposit.setName(name);
            return this;
        }

        public DepositBuilder withAccountNumber(String accountNumber) {
            deposit.setAccountNumber(accountNumber);
            return this;
        }

        public Deposit build() {
            return deposit;
        }
    }
}
