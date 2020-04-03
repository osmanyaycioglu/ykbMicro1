package com.ykb.micro;

import org.springframework.data.repository.CrudRepository;

public interface ICustomerDAO extends CrudRepository<Customer, String> {

}
