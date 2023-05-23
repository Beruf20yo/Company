package main.java.employee;

import java.util.Comparator;

public class TopSalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        return Integer.compare(emp2.getMonthSalary(), emp1.getMonthSalary());
    }
}
