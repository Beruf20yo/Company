package main.java.employee;

import main.java.Company;

public class TopManager implements Employee {
    protected final int ratePerMounth = 80000;
    protected int monthSalary;
    Company company;

    public TopManager(Company company) {
        this.monthSalary = (company.getIncome() > 2000000) ? ((ratePerMounth * 5) / 2) : ratePerMounth;
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        this.monthSalary = (company.getIncome() > 2000000) ? (ratePerMounth * 5 / 2) : ratePerMounth;
        return monthSalary;
    }
}
