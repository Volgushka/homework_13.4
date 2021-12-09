package myCompany.java.emp;
import myCompany.java.Company;

public class Manager implements Employee{

    double fixedSalary = 30000.0;
    String reportingPeriod = Company.getReportingPeriod();


    @Override
    public double getMonthFixedSalary() {
        return fixedSalary;
    }

    @Override
    public double getMonthBonus(String reportingPeriod) {
        return (Math.random()* 25000) + 115000;
    }

    @Override
    public double getMonthSalary() {
        return fixedSalary + getMonthBonus(reportingPeriod);
    }
}
