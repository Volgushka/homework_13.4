package myCompany.java.emp;
import myCompany.java.Company;

public class TopManager implements Employee {

    Company company = new Company();

    double fixedSalary = 80000.0;
    double bonusPersent = 1.5;
    double minimumProfit = 10000000.0;
    double monthIncome = company.getIncome("may2020");
    String reportingPeriod = Company.getReportingPeriod();

    @Override
    public double getMonthFixedSalary() {
        return fixedSalary;
    }

    @Override
    public double getMonthBonus(String reportingPeriod) {
        return (company.getIncome("may2020") > minimumProfit) ? fixedSalary* bonusPersent : 0;
    }

    @Override
    public double getMonthSalary() {
        return fixedSalary + getMonthBonus(reportingPeriod);
    }
}
