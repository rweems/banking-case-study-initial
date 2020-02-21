package com.example.banking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AutoLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private long clientId;
    private String name;
    private double balance;

    public AutoLoan() {
    }

    public AutoLoan(long clientId, String name, double balance) {
        this.clientId = clientId;
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
        return "AutoLoanModel{" +
                "Id=" + id +
                ", clientId=" + clientId +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    // The Builder Pattern is an example of a Fluent API
    public static AutoLoanBuilder builder() {
        return new AutoLoanBuilder();
    }

    public static final class AutoLoanBuilder {

        private AutoLoan autoLoan;

        private AutoLoanBuilder() {
            autoLoan = new AutoLoan();
        }

        public AutoLoanBuilder withId(Long id) {
            autoLoan.setId(id);
            return this;
        }

        public AutoLoanBuilder withBalance(double balance) {
            autoLoan.setBalance(balance);
            return this;
        }
        public AutoLoanBuilder withClientId(long clientId) {
            autoLoan.setClientId(clientId);
            return this;
        }
        public AutoLoanBuilder withName(String name) {
            autoLoan.setName(name);
            return this;
        }

        public AutoLoan build() {
            return autoLoan;
        }
    }
}
