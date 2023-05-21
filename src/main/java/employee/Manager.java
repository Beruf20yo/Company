package main.java.employee;

import main.java.Company;

public class Manager implements Employee {

    private final int ratePerMounth = 60000;
    public int incomePart;
    protected int monthSalary;
    Company company;

    public Manager(Company company) {
        this.company = company;
        this.incomePart = setCompanyIncome();
    }

    @Override
    public int getMonthSalary() {
        return monthSalary;
    }

    public int setCompanyIncome() {
        int startRange = 115000;
        int endRange = 140000;
        int incomePart = startRange + (int) (Math.random() * endRange);
        this.monthSalary = (incomePart * 5 / 100) + ratePerMounth;
        return incomePart;

    }

}
