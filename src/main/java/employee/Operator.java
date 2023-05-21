package main.java.employee;

import main.java.Company;

public class Operator implements Employee {
    private final int ratePerMounth = 40000;
    protected int monthSalary;
    Company company;

    public Operator(Company company) {
        this.company = company;
    }

    public int getMonthSalary() {
        this.monthSalary = ratePerMounth;
        return monthSalary;
    }

    public int setCompanyIncome() {
        return 0;
    }
}
