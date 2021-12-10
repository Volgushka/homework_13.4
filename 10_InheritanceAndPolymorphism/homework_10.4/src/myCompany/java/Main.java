package myCompany.java;

import myCompany.java.emp.TopManager;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Company myCompany = new Company(15000000.0);
        Company myCompany2 = new Company(18000000.0);
        Company myCompany3 = new Company(20000000.0);

        myCompany.hire("Анна", "TopManager");
        myCompany.hire("Алик", "TopManager");
        myCompany.hire("Алла", "TopManager");
        myCompany.hire("Алиса", "TopManager");
        myCompany.hire("Артем", "TopManager");
        myCompany.hire("Альберт", "TopManager");
        myCompany.hire("Аверьян", "TopManager");
        myCompany.hire("Ася", "TopManager");
        myCompany.hire("Ада", "TopManager");
        myCompany.hire("Алексей", "TopManager");

        myCompany.hireList.add("Борис");
        myCompany.hireList.add("Барбара");
        myCompany.hireList.add("Бонифаций");
        myCompany.hireList.add("Белла");
        myCompany.hireList.add("Бронислав");

        myCompany.hireAll("Manager");
        myCompany.hireList.clear();

        myCompany.hireList.add("Василий");
        myCompany.hireList.add("Варвара");
        myCompany.hireList.add("Вера");
        myCompany.hireList.add("Виктор");
        myCompany.hireList.add("Вячеслав");
        myCompany.hireAll("Operator");

        System.out.println(myCompany.employeesList);

        myCompany.createSalaryList(myCompany);

        for (String lowestSalary : myCompany.getLowestSalaryStaff(10)) {
            System.out.println(lowestSalary);
        }

        for (String TopSalary : myCompany.getTopSalaryStaff(15)) {
            System.out.println(TopSalary);
        }


        myCompany.fire("Ада");
        myCompany.fire("Алексей");


    }
}

//    Создайте и наймите в компанию: 180m операторов Operator, 80 менеджеров по продажам Manager, 10 топ-менеджеров TopManager.
//    Распечатайте список из 10–15 самых высоких зарплат в компании.
//    Распечатайте список из 30 самых низких зарплат в компании.
//            Увольте 50% сотрудников.
//    Распечатайте список из 10–15 самых высоких зарплат в компании.
//    Распечатайте список из 30 самых низких зарплат в компании.

