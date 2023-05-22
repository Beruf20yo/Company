package main.java.employee;

import main.java.Company;

public class TopManager implements Employee {
    private final int ratePerMounth = 80000;
    protected int monthSalary;
    Company company;

    public TopManager(Company company) {
        this.monthSalary = (company.getIncome() > 2000000) ? (ratePerMounth * 5 / 2) : ratePerMounth;
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        return monthSalary;
    }

    public int setCompanyIncome() {
        return 0;
    }
}
