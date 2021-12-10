package myCompany.java.emp;
import myCompany.java.Company;

public class Manager implements Employee{

    private Company company;

    public Manager(Company company) {
        this.company = company;
    }

    double fixedSalary = 30000.0;

    @Override
    public double getMonthFixedSalary() {
        return fixedSalary;
    }

    @Override
    public double getMonthBonus() {
        return (Math.random()* 25000) + 115000;
    }

    @Override
    public double getMonthSalary() {
        return fixedSalary + getMonthBonus();
    }
}
