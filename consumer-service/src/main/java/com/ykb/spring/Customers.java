package com.ykb.spring;

import java.util.ArrayList;
import java.util.List;

public class Customers {

    private List<Customer> customerList = new ArrayList<>();

    public void addCustomer(final Customer customerParam) {
        this.customerList.add(customerParam);
    }

    public List<Customer> getCustomerList() {
        return this.customerList;
    }


    public void setCustomerList(final List<Customer> customerListParam) {
        this.customerList = customerListParam;
    }


}
