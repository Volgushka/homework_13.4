package myCompany.java;

public class TopManager implements Employee {

    Company helperObject = new Company();

    double fixedSalary = 80000.0;
    double bonusPersent = 1.5;
    double minimumProfit = 10000000.0;
    double monthIncome = helperObject.getIncome("may2020");
    String reportingPeriod = Company.getReportingPeriod();



    @Override
    public double getMonthFixedSalary() {
        return fixedSalary;
    }

    @Override
    public double getMonthBonus(String reportingPeriod) {
        return (monthIncome < minimumProfit) ? fixedSalary* bonusPersent : 0;
    }

    @Override
    public double getMonthSalary() {
        return fixedSalary + getMonthBonus(reportingPeriod);
    }
}
