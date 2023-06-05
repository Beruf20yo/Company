package main.java.employee;

import main.java.Company;

public class Manager extends Employee {
    protected int companyIncome;

    public Manager(Company company) {
        this.company = company;
        this.companyIncome = setCompanyIncome();
        company.setIncome(companyIncome);
    }
    
    public int setCompanyIncome() {
        int startRange = 115000;
        int endRange = 140000;
        int incomePart = startRange + (int) (Math.random() * endRange);
        int ratePerMounth = 60000;
        this.monthSalary = (incomePart * 5 / 100) + ratePerMounth;
        return incomePart;
    }

}
