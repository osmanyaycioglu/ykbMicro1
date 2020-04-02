package com.ykb.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ykb.spring.beans.EmployeeManager;

@SpringBootApplication
//@Component
//@Controller
//@RestController
//@Configuration
//@Service
//@Repository
public class MyFirstSpringBootApplication implements ApplicationRunner {

    private final EmployeeManager employeeManager;

    @Autowired
    @Qualifier("osman")
    private EmployeeManager       employeeManager2;


    @Autowired
    public MyFirstSpringBootApplication(@Qualifier("osman") final EmployeeManager employeeManagerParam) {
        this.employeeManager = employeeManagerParam;
        System.out.println(this.employeeManager.getEmployees());
    }

    @Override
    public void run(final ApplicationArguments argsParam) throws Exception {
        System.out.println(this.employeeManager.getEmployees());
    }

    public static void main(final String[] args) {
        SpringApplication.run(MyFirstSpringBootApplication.class,
                              args);
    }

    @Autowired
    @Qualifier("osman")
    public void myMethod(final EmployeeManager employeeManager) {
        System.out.println("Method Wire : " + employeeManager.getEmployees());
    }

}
