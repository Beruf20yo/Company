package main.java;

import main.java.employee.Employee;
import main.java.employee.Manager;
import main.java.employee.Operator;
import main.java.employee.TopManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Company> companies = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в нашу программу" +
                "\nЧто вы хотите сделать?" + "\n" +
                "1. Создать компанию" + "\n" +
                "2. Покинуть программу");
        String input = scanner.nextLine();
        int chose = Integer.parseInt(input);
        switch (chose) {
            case 1:
                newCompany();
                break;
            case 2:
                System.out.println("Всего доброго");
                System.exit(0);
        }
    }

    public static void newCompany() {
        System.out.println("Введите название компании: ");
        String input = scanner.nextLine();
        Company company = new Company();
        company.setName(input);
        System.out.println("Имя компании установлено!");
        companies.add(company);
        mainInterface(company);
    }

    public static void choseCompany() {
        System.out.println("На данный момент у вас есть компании: ");
        int i = 0;
        for (Company company : companies) {
            System.out.println(i + ". " + company.getName());
            i++;
        }
        System.out.println("Что вы хотите сделать?" + "\n" +
                "1. Сменить компанию" + "\n" +
                "2. Создать новую компанию");
        String input = scanner.nextLine();
        int chose = Integer.parseInt(input);
        switch (chose) {
            case 1:
                System.out.println("На данный момент у вас есть компании: ");
                i = 0;
                for (Company company : companies) {
                    System.out.println(i + company.getName());
                    i++;
                }
                System.out.println("Выберите номер компании: ");
                input = scanner.nextLine();
                int companyID = Integer.parseInt(input);
                System.out.println("Теперь вы работаете с компанией " + companies.get(companyID).getName());
                mainInterface(companies.get(companyID));
                break;
            case 2:
                newCompany();
                break;

        }
    }

    public static void mainInterface(Company company) {
        while (true) {
            System.out.println("Основная программа" + "\n" +
                    "Что вы хотите сделать?" + "\n" +
                    "1. Добавить сотрудника" + "\n" +
                    "2. Удалить сотрудника" + "\n" +
                    "3. Узнать доход компании" + "\n" +
                    "4. Узнать информацию о зарплатах компании" + "\n" +
                    "5. Создать ещё одну компанию/Выбрать другую" + "\n" +
                    "6. Добавить сотрудников списком");// Список заранее прописан в программе
            String input = scanner.nextLine();
            if (input.replace(" ", "").equalsIgnoreCase("exit")) {
                System.out.println("Всего доброго");
                System.exit(0);
            }
            int chose = Integer.parseInt(input);
            int count;
            switch (chose) {
                case 1:
                    addEmployee(company);
                    break;
                case 2:
                    deleteEmployee(company);
                    break;
                case 3:
                    System.out.println("Доход вашей компании: " + "\n" + company.getIncome());
                    break;
                case 4:
                    getSalaryInfo(company);
                    break;
                case 5:
                    choseCompany();
                    break;
                case 6:
                    List<Employee> employeeToAdd = new ArrayList<>(Arrays.asList(new Manager(company),
                            new TopManager(company), new Operator(company),
                            new Manager(company), new Manager(company)));
                    company.hireAll(employeeToAdd);
                    break;

            }
        }
    }
    public static void getSalaryInfo(Company company){
        System.out.println("Что вы хотите сделать?" + "\n" +
                "1. Узнать все уникальные зарплаты" + "\n" +
                "2. Узнать самые высокие зарплаты"+ "\n" +
                "3. Узнать самые низкие зарплаты");
        String input = scanner.nextLine();
        int chose = Integer.parseInt(input);
        System.out.println("");
        switch (chose){
            case 1:
                for(Employee employee: company.getSalaryStaff()){
                    System.out.println(employee.getMonthSalary());
                    break;
                }
            case 2:
                System.out.println("Введите количество зарплат: ");
                input = scanner.nextLine();
                int count = Integer.parseInt(input);
                for (Employee employee : company.getTopSalaryStaff(count)) {
                    System.out.println(employee.getMonthSalary());
                }
                break;
            case 3:
                System.out.println("Введите количество зарплат: ");
                input = scanner.nextLine();
                count = Integer.parseInt(input);

                for (Employee employee : company.getLowestSalaryStaff(count)) {
                    System.out.println(employee);
                }
                break;
        }


    }
    public static void deleteEmployee(Company company) {
        System.out.println("Как вы хотите удалить сотрудника?" + "\n" +
                "1. Удалить нескольких" + "\n" +
                "2. Удалить по ID" + "\n" +
                "3. Удалить любого");
        String input = scanner.nextLine();
        int chose = Integer.parseInt(input);
        switch (chose) {
            case 1:
                System.out.println("Сколько сотрудников нужно удалить?" + "\n" +
                        "1. По количеству" + "\n" +
                        "2. По процентам");
                input = scanner.nextLine();
                int count = Integer.parseInt(input);
                switch (count) {
                    case 1:
                        System.out.println("Введите кол-во сотрудников для удаления");
                        input = scanner.nextLine();
                        count = Integer.parseInt(input);
                        while (count != 0 || company.employees.isEmpty()) {
                            company.fire();
                            count--;
                        }
                        System.out.println("Сотрудники удалены");
                        mainInterface(company);
                        break;
                    case 2:
                        System.out.println("Введите процент сотрудников для удаления");
                        input = scanner.nextLine();
                        count = Integer.parseInt(input);
                        int i = company.employees.size() * count / 100;
                        while (i != 0 || company.employees.isEmpty()) {
                            company.fire();
                            i--;
                        }
                        System.out.println("Сотрудники удалены");
                        mainInterface(company);
                        break;
                }
                if (count == 1) {
                    while (count != 0 || company.employees.isEmpty()) {
                        company.fire();
                        count--;
                    }
                    System.out.println("Сотрудники удалены");
                    mainInterface(company);
                    break;
                } else {

                }

            case 2:
                System.out.println("Введите ID сотрудника в списке: ");
                input = scanner.nextLine();
                int id = Integer.parseInt(input);
                company.fire(id);
                mainInterface(company);
                break;
            case 3:
                company.fire();
                System.out.println("Сотрудник удалён");
                mainInterface(company);
                break;
        }

    }

    public static void addEmployee(Company company) {
        System.out.println("Какого сотрудника вы хотите добавить?" + "\n" +
                "1. Manager" + "\n" +
                "2. TopManager" + "\n" +
                "3. Operator");
        String input = scanner.nextLine();
        int chose = Integer.parseInt(input);
        int count;

        switch (chose) {
            case 1:

                System.out.println("Сколько сотрудников нужно добавить?");
                input = scanner.nextLine();
                count = Integer.parseInt(input);
                while (count != 0) {
                    Employee employee = new Manager(company);
                    company.hire(employee);
                    count--;
                }
                System.out.println("Сотрудник(и) добавлен(ы)");
                mainInterface(company);
                break;
            case 2:

                System.out.println("Сколько сотрудников нужно добавить?");
                input = scanner.nextLine();
                count = Integer.parseInt(input);
                while (count != 0) {
                    Employee employee = new TopManager(company);
                    company.hire(employee);
                    count--;
                }
                System.out.println("Сотрудник(и) добавлен(ы)");
                mainInterface(company);
                break;
            case 3:
                System.out.println("Сколько сотрудников нужно добавить?");
                input = scanner.nextLine();
                count = Integer.parseInt(input);
                while (count != 0) {
                    Employee employee = new Operator(company);
                    company.hire(employee);
                    count--;
                }
                System.out.println("Сотрудник(и) добавлен(ы)");
                mainInterface(company);
                break;
        }
    }

}
