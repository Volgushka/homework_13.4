package myCompany.java.emp;

import myCompany.java.Company;

public class TopManager<bonusPersent> implements Employee {

    private Company company;
    double income;

    public TopManager(Company company) {
        this.company = company;
        this.income = company.getIncom();
    }

    double fixedSalary = 80000.0;
    double bonusPersent = 1.5;
    double minimumProfit = 10000000.0;

    @Override
    public double getMonthFixedSalary() {
        return fixedSalary;
    }

    @Override
    public double getMonthBonus() {
        return (income > minimumProfit) ? fixedSalary * bonusPersent : 0;
    }

    @Override
    public double getMonthSalary() {
        return fixedSalary + getMonthBonus();
    }
}
