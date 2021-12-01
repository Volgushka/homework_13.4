package myCompany.java;

import java.util.*;

public class Company {
    public static String reportingPeriod;
    TreeMap<String, Double> incomeOfCompany = new TreeMap<>();
    ArrayList<String> hireList = new ArrayList<>();
    ArrayList<Double> salaryList = new ArrayList<>();
    HashMap<String, String> employeesList = new HashMap<>();


    public static String getReportingPeriod() {
        return reportingPeriod;
    }

    enum positionList {Manager, TopManager, Operator}

    public double getIncome(String reportingPeriod) {
        return incomeOfCompany.getOrDefault(reportingPeriod, 0.0);
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

    public void createSalaryList(String reportingPeriod) {
        Manager manager = new Manager();
        TopManager topManager = new TopManager();
        Operator operator = new Operator();
        for (Map.Entry<String, String> some : employeesList.entrySet()) {
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

