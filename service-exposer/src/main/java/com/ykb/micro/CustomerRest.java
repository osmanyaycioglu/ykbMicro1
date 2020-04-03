package com.ykb.micro;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ICustomerDAO custDao;

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody final Customer customer) {
        this.custDao.save(customer);
        return customer;
    }

    @GetMapping("/getall")
    public Customers getAllCustomers() {
        Iterable<Customer> findAllLoc = this.custDao.findAll();
        Customers customers = new Customers();
        for (Customer customerLoc : findAllLoc) {
            customers.addCustomer(customerLoc);
        }
        return customers;
    }

    @GetMapping("/get/{username}")
    public Customer getCustomer(@PathVariable("username") final String username) {
        Optional<Customer> findByIdLoc = this.custDao.findById(username);
        if (findByIdLoc.isPresent()) {
            return findByIdLoc.get();
        }
        return null;
    }

}
