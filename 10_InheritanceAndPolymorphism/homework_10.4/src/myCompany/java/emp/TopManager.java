package myCompany.java.emp;

import myCompany.java.Company;

public class TopManager<bonusPersent> implements Employee {

    private Company company;
    double income;
    double fixedSalary;
    double bonusPersent;
    double minimumProfit ;

    public TopManager(Company company) {
        this.company = company;
        this.income = company.getIncom();
        fixedSalary = 80000.0;
        bonusPersent = 1.5;
        minimumProfit = 10000000.0;;
    }

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
