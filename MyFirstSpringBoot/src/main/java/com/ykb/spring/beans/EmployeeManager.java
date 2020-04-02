package com.ykb.spring.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ykb.spring.Employee;

// @Component
// @Scope("protype")
public class EmployeeManager {

    public EmployeeManager() {
        System.out.println("EmployeeManager yaratıldı");
    }

    private final Map<String, Employee> empMap = new HashMap<>();

    public void addEmployee(final Employee emp) {
        this.empMap.put(emp.getName() + "_" + emp.getSurname(),
                        emp);
    }

    public List<Employee> getEmployees() {
        List<Employee> m = new ArrayList<>(this.empMap.values());
        return m;
    }
}
