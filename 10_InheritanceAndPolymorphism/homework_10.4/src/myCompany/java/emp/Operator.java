package myCompany.java.emp;
import myCompany.java.Company;

/**
 * Класс Operartor.
 * Зарплата складывается только из фиксированной части.

 */

public class Operator implements Employee {

    double fixedSalary = 45000.0;
    Company helperObject = new Company();
    String reportingPeriod = Company.getReportingPeriod();


    @Override
    public double getMonthFixedSalary() {
        return fixedSalary;
    }

    @Override
    public double getMonthBonus(String reportingPeriod) {
        return 0;
    }

    @Override
    public double getMonthSalary() {
        return fixedSalary + getMonthBonus(reportingPeriod);
    }
}
