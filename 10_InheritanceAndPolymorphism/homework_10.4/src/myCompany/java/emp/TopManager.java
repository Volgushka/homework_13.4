package myCompany.java.emp;
import myCompany.java.Company;

public class TopManager implements Employee {

   private Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    double income = company != null ? company.getIncom() : 0;
    double fixedSalary = 80000.0;
    double bonusPersent = 1.5;
    double minimumProfit = 10000000.0;

    @Override
    public double getMonthFixedSalary() {
        return fixedSalary;
    }

    @Override
    public double getMonthBonus() {
        return (income > minimumProfit) ? fixedSalary* bonusPersent : 0;
    }

    @Override
    public double getMonthSalary() {
        return fixedSalary + getMonthBonus();
    }
}
