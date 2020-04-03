package com.ykb.spring;

public class Customer {

    private String username;
    private String name;
    private String surname;
    private double account;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public double getAccount() {
        return this.account;
    }

    public void setAccount(final double accountParam) {
        this.account = accountParam;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String usernameParam) {
        this.username = usernameParam;
    }


}
