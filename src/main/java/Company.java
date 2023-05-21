package main.java;

import main.java.employee.Employee;
import main.java.employee.LowSalaryComparetor;
import main.java.employee.TopSalaryComparator;
import main.java.exceptions.WrongCount;
import main.java.exceptions.WrongNumber;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class Company {
    protected List<Employee> employees = new ArrayList<>();
    protected int income = 0;
    String name;

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
            if (id > employees.size() - 1 || id < 0) {
                throw new WrongNumber();
            }
            employees.remove(id);
        }catch (WrongNumber e){
            System.out.println(e);
        }



    }

    public void fire() {
        int startRange = 0;
        int endRange = employees.size();
        employees.remove(startRange + (int) (Math.random() * endRange));
    }

    public List<Employee> getTopSalaryStaff(int count) {

            TreeSet<Employee> topSalaryTree = new TreeSet<>(new TopSalaryComparator());
            List<Employee> topSalaryList = new ArrayList<>();
            topSalaryTree.addAll(employees);

            Iterator<Employee> it = topSalaryTree.iterator();
            try {
                if (count > topSalaryTree.size() - 1 || count < 0) {
                    throw new WrongCount();
                }
            while (count != 0) {
                topSalaryList.add(it.next());
                count--;
            }
        }catch (WrongCount e){
            System.out.println(e);
        }
        return topSalaryList;
    }
    public List<Employee> getSalaryStaff(){
        TreeSet<Employee> topSalaryTree = new TreeSet<>(new TopSalaryComparator());
        List<Employee> SalaryList = new ArrayList<>();
        topSalaryTree.addAll(employees);
        Iterator<Employee> it = topSalaryTree.iterator();
        while (it.hasNext()){
            SalaryList.add(it.next());
        }
        return SalaryList;
    }
    public List<Employee> getLowestSalaryStaff(int count) {
        TreeSet<Employee> lowSalaryTree = new TreeSet<>(new LowSalaryComparetor());
        List<Employee> lowSalaryList = new ArrayList<>();
        lowSalaryTree.addAll(employees);
        Iterator<Employee> it = lowSalaryTree.iterator();
        try {
            if (count > lowSalaryTree.size() - 1 || count < 0) {
                throw new WrongCount();
            }
        while (count != 0) {
            lowSalaryList.add(it.next());
            count--;
        }

        }catch (WrongCount e){
            System.out.println(e);
        }
        return lowSalaryList;
    }

    public int getIncome() {
        if (employees.isEmpty()) {
            return 0;
        } else {
            for (Employee person : employees) {
                income += person.setCompanyIncome();
            }
            return this.income;
        }

    }
}
