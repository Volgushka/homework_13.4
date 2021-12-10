package myCompany.java.emp;
import myCompany.java.Company;

/**
 * Класс Operartor.
 * Зарплата складывается только из фиксированной части.

 */

public class Operator implements Employee {

    private Company company;

    public Operator(Company company) {
        this.company = company;
    }

    double fixedSalary = 45000.0;

    @Override
    public double getMonthFixedSalary() {
        return fixedSalary;
    }

    @Override
    public double getMonthBonus() {
        return 0;
    }

    @Override
    public double getMonthSalary() {
        return fixedSalary + getMonthBonus();
    }
}
