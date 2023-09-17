package com.example.myDemo.service;

import com.example.myDemo.entity.Employee;
import com.example.myDemo.entity.Member;

import java.util.List;

public interface EmployeeService {

    List<Employee>findAll();

    Employee findById(int theId);

    void save(Employee theEmployee);

    void deleteById(int theId);


}
