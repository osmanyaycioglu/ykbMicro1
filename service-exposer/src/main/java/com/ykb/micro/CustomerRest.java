package com.ykb.micro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;

@RestController
@RequestMapping("/customer")
@ApplicationScope
public class CustomerRest {

    private final Map<String, Customer> customerMap = new HashMap<>();

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody final Customer customer) {
        this.customerMap.put(customer.getUsername(),
                             customer);
        return customer;
    }

    @GetMapping("/getall")
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(this.customerMap.values());
    }

    @GetMapping("/get/{username}")
    public Customer getCustomer(@PathVariable("username") final String username) {
        return this.customerMap.get(username);
    }

}
