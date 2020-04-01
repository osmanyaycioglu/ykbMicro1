package com.ykb.spring;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
@Validated
public class MyFirstRest {

    @GetMapping("/hello6/{yas}")
    public Employee hello6(@RequestParam("isim") final String name,
                           @RequestParam("soy") final String surname,
                           @PathVariable("yas") final int age) {
        Employee employeeLoc = new Employee();
        employeeLoc.setName(name);
        employeeLoc.setSurname(surname);
        employeeLoc.setAge(age);
        if (age > 30) {
            throw new IllegalArgumentException("age 30 dan büyük olamaz");
        }
        if (age < 10) {
            throw new IllegalStateException("age 10 dan küçük olamaz");
        }
        return employeeLoc;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleException(final IllegalArgumentException exp) {
        return ResponseEntity.status(380)
                             .body(exp.getMessage());
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorObj> handleException2(final IllegalStateException exp) {
        return ResponseEntity.status(300)
                             .body(new ErrorObj(exp.getMessage(),
                                                120));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handleException3(final Exception exp) {
        if (exp instanceof ConstraintViolationException) {
            ConstraintViolationException cexp = (ConstraintViolationException) exp;
            Set<ConstraintViolation<?>> constraintViolationsLoc = cexp.getConstraintViolations();
            ErrorObj errorStr = new ErrorObj("Validation Error",
                                             455);

            for (ConstraintViolation<?> constraintViolationLoc : constraintViolationsLoc) {
                errorStr.addError(new ErrorObj(constraintViolationLoc.getMessage(),
                                               100));
            }
            return ResponseEntity.status(300)
                                 .body(errorStr);
        } else if (exp instanceof MethodArgumentNotValidException) {

            MethodArgumentNotValidException mexp = (MethodArgumentNotValidException) exp;
            List<ObjectError> allErrorsLoc = mexp.getBindingResult()
                                                 .getAllErrors();
            ErrorObj errorStr = new ErrorObj("Validation Error",
                                             455);
            for (ObjectError objectErrorLoc : allErrorsLoc) {
                errorStr.addError(new ErrorObj(objectErrorLoc.getDefaultMessage(),
                                               100));
            }

            return ResponseEntity.status(300)
                                 .body(errorStr);

        }

        return ResponseEntity.status(300)
                             .body(new ErrorObj(exp.getMessage(),
                                                120));
    }

    @GetMapping("/hello7/{yas}")
    public Employee hello7(@RequestParam("isim") final String name,
                           @NotNull @Size(min = 3,
                                          max = 20,
                                          message = "Surname 3 ile 20 arasında olmalı") @RequestParam("soy") final String surname,
                           @Max(value = 30,
                                message = "age 30 dan büyük olamaz") @Min(value = 10,
                                                                          message = "age 10 dan küçük olamaz") @PathVariable("yas") final int age) {
        Employee employeeLoc = new Employee();
        employeeLoc.setName(name);
        employeeLoc.setSurname(surname);
        employeeLoc.setAge(age);
        return employeeLoc;
    }


    @PostMapping("/hello8")
    public Employee hello8(@Validated @RequestBody final Employee employeeParam) {
        employeeParam.setAge(100);
        return employeeParam;
    }

    @PostMapping(value = "/hello9",
                 consumes = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 },
                 produces = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 })
    public Employee hello9(@RequestBody final Employee employeeParam) {
        employeeParam.setAge(100);
        return employeeParam;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @PostMapping("/hello")
    public String hello2() {
        return "hello 2";
    }

    @GetMapping("/hello3/{isim}/{soy}")
    public String hello3(@PathVariable("isim") final String name,
                         @PathVariable("soy") final String surname) {
        return "hello " + name + " " + surname;
    }

    @GetMapping("/hello4/{yas}")
    public String hello4(@RequestParam("isim") final String name,
                         @RequestParam("soy") final String surname,
                         @PathVariable("yas") final int age) {
        return "hello " + name + " " + surname + " " + age;
    }

    @GetMapping("/hello5/{yas}")
    public String hello5(@RequestHeader("isim") final String name,
                         @RequestHeader("soy") final String surname,
                         @PathVariable("yas") final int age) {
        return "hello " + name + " " + surname + " " + age;
    }


}
