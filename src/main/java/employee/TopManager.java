package main.java.employee;

import main.java.Company;

public class TopManager extends Employee {
    protected final int ratePerMounth = 80000;
    public TopManager(Company company) {
        this.monthSalary = (company.getIncome() > 2000000) ? ((ratePerMounth * 5) / 2) : ratePerMounth;
        this.company = company;
    }
}
