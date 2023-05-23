package main.java.employee;

import main.java.Company;

public class Operator implements Employee {
    protected int monthSalary = 40000;
    Company company;

    public Operator(Company company) {
        this.company = company;
    }

    public int getMonthSalary() {
        return monthSalary;
    }


}
