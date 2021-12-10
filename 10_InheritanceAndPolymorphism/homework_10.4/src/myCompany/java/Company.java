package myCompany.java;

import myCompany.java.emp.Manager;
import myCompany.java.emp.Operator;
import myCompany.java.emp.TopManager;

import java.util.*;

public class Company {

    private double incomeOfCompany;

    public Company(Double incomeOfCompany){
        this.incomeOfCompany = incomeOfCompany;
    }

    public double getIncom(){
        return incomeOfCompany;
    }

    Map<String, String> employeesList = new HashMap<>();

    ArrayList<String> hireList = new ArrayList<>();
    ArrayList<Double> salaryList = new ArrayList<>();

    public Company(Map<String, String> employeesList) {
        this.employeesList = employeesList;
    }

    public void hire(String name, String position) {
        employeesList.put(name, position);
    }

    public void hireAll(String position) {
        for (String emp : hireList) {
            employeesList.put(emp, position);
        }
    }

    public void fire(String name) {
        employeesList.remove(name);
    }

    public void createSalaryList(Company company) {
        for (Map.Entry<String, String> some : employeesList.entrySet()) {
            Manager manager = new Manager(company);
            TopManager topManager = new TopManager(company);
            Operator operator = new Operator(company);
            String position = some.getValue();
            switch (position) {
                case "Manager" -> {
                    String round = String.format("%.1f", manager.getMonthSalary()).replace(",", ".");
                    salaryList.add(Double.parseDouble(round));
                }
                case "TopManager" -> salaryList.add(topManager.getMonthSalary());
                case "Operator" -> salaryList.add(operator.getMonthSalary());
            }
        }
    }

    List<String> getTopSalaryStaff(int count) {
        List<String> TopSalaryList = new ArrayList<>();
        Collections.reverse(salaryList);
        for (int i = 0; i < count; i++) {
            TopSalaryList.add(salaryList.get(i) + " руб.");
        }
        System.out.println("Это самые высокие зарплаты");
        return TopSalaryList;
    }

    List<String> getLowestSalaryStaff(int count) {
        List<String> LowerSalaryList = new ArrayList<>();
        Collections.sort(salaryList);
        for (int i = 0; i < count; i++) {
            LowerSalaryList.add(salaryList.get(i) + " руб.");
        }
        System.out.println("Это самые низкие зарплаты");
        return LowerSalaryList;
    }

}

