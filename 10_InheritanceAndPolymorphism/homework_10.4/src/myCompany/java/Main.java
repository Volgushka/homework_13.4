package myCompany.java;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Company company = new Company();

        Company.reportingPeriod = "may2020";
        company.incomeOfCompany.put("may2020", 15000000.0);

        company.hire("Анна", "TopManager");
        company.hire("Алик", "TopManager");
        company.hire("Алла", "TopManager");
        company.hire("Алиса", "TopManager");
        company.hire("Артем", "TopManager");
        company.hire("Альберт", "TopManager");
        company.hire("Аверьян", "TopManager");
        company.hire("Ася", "TopManager");
        company.hire("Ада", "TopManager");
        company.hire("Алексей", "TopManager");

        company.hireList.add("Борис");
        company.hireList.add("Барбара");
        company.hireList.add("Бонифаций");
        company.hireList.add("Белла");
        company.hireList.add("Бронислав");

        company.hireAll("Manager");
        company.hireList.clear();

        company.hireList.add("Василий");
        company.hireList.add("Варвара");
        company.hireList.add("Вера");
        company.hireList.add("Виктор");
        company.hireList.add("Вячеслав");
        company.hireAll("Operator");

        System.out.println(company.employeesList);

        company.createSalaryList("may2020");

        for (String lowestSalary : company.getLowestSalaryStaff(10)) {
            System.out.println(lowestSalary);
        }

        for (String TopSalary : company.getTopSalaryStaff(15)) {
            System.out.println(TopSalary);
        }


        company.fire("Ада");
        company.fire("Алексей");


    }
}

//    Создайте и наймите в компанию: 180 операторов Operator, 80 менеджеров по продажам Manager, 10 топ-менеджеров TopManager.
//    Распечатайте список из 10–15 самых высоких зарплат в компании.
//    Распечатайте список из 30 самых низких зарплат в компании.
//            Увольте 50% сотрудников.
//    Распечатайте список из 10–15 самых высоких зарплат в компании.
//    Распечатайте список из 30 самых низких зарплат в компании.

