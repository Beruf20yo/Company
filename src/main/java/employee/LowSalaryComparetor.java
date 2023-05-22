package main.java.employee;

import java.util.Comparator;

public class LowSalaryComparetor implements Comparator<Employee> {

        @Override
        public int compare(Employee emp1, Employee emp2) {
            if (emp1.getMonthSalary() < emp2.getMonthSalary()) {
                return -1;
            } else if (emp1.getMonthSalary() == emp2.getMonthSalary()) {
                return 0;
            } else {
                return 1;
            }
        }

}
