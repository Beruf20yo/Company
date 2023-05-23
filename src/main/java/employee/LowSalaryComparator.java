package main.java.employee;

import java.util.Comparator;

public class LowSalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        return Integer.compare(emp1.getMonthSalary(), emp2.getMonthSalary());
    }

}
