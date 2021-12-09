import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {

        Date beginOfPeriod = new Date(117,0,01);
        Date endOfPeriod  = new Date(117,11,31);

        Optional <Employee> optional = staff.stream().filter(employee -> employee.getWorkStart().before(endOfPeriod) && employee.getWorkStart().after(beginOfPeriod)).max(Comparator.comparing(Employee::getSalary));

        return optional.get();
    }
}
//TODO Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
// кто пришёл в году, указанном в переменной year
