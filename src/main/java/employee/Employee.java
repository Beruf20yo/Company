package main.java.employee;


import lombok.Getter;
import main.java.Company;

@Getter
public abstract class Employee {
    int monthSalary;
    Company company;
}
