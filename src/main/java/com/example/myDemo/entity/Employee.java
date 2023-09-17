package com.example.myDemo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_no")
    private int empNo;

    @Column(name = "emp_id")
    private String employeeId;

    @Column(name = "password")
    private String password;

    @Column(name = "state")
    private String state;


    public Employee() {
    }

    public Employee(String employeeId, String password, String state) {
        this.employeeId = employeeId;
        this.password = password;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empN0=" + empNo +
                ", employeeId='" + employeeId + '\'' +
                ", password='" + password + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
