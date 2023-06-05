package main.java;

import main.java.employee.Employee;

import java.util.*;

public class Company {
    protected List<Employee> employees = new ArrayList<>();
    String name;
    protected int income;

    public void setIncome(int income) {
        this.income += income;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(List<Employee> lisdToAdd) {
        employees.addAll(lisdToAdd);
    }

    public void fire(int id) {
        try {
            employees.remove(id);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Вы ввели неверное чилсо");
        }

    }

    public void fire() {
        int startRange = 0;
        int endRange = employees.size();
        employees.remove(startRange + (int) (Math.random() * endRange));
    }

    public List<Employee> getSalaryStaff() {
        TreeSet<Employee> SalaryTree = new TreeSet<>((emp1, emp2) -> Integer.compare(emp2.getMonthSalary(), emp1.getMonthSalary()));
        SalaryTree.addAll(employees);
        return new ArrayList<>(SalaryTree);
    }

    public List<Employee> getTopOrLowSalaryStaff(int count, String setTopOrLow) {
        TreeSet<Employee> SalaryTree = null;
        switch (setTopOrLow){
            case "Top" -> SalaryTree = new TreeSet<>((emp1, emp2) -> Integer.compare(emp2.getMonthSalary(), emp1.getMonthSalary()));
            case "Low" -> SalaryTree = new TreeSet<>(Comparator.comparingInt(Employee::getMonthSalary));
        }

        List<Employee> SalaryList = new ArrayList<>();
        SalaryTree.addAll(employees);
        Iterator<Employee> it = SalaryTree.iterator();
        try {
            if (count > SalaryTree.size() - 1 || count < 0) {
                throw new IllegalStateException();
            }
            while (count != 0) {
                SalaryList.add(it.next());
                count--;
            }
        } catch (IllegalStateException e) {
            System.out.println("Вы ввели неверное кол-во зарплат, всего уникальных зарплат = " + SalaryTree.size());
        }
        return SalaryList;

    }

    public int getIncome() {
        return income;

    }
}
