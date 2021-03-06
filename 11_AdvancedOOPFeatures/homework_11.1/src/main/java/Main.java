import net.sf.saxon.style.XSLOutput;

import java.util.*;

public class Main {

   public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        System.out.println(staff);


    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
//      staff.sort(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName)); 1 вариант
//      Collections.sort(staff);                                                               2 вариант
       // staff.sort(new SalaryComparator().thenComparing(new NameComparator()));            //     3 вариант
        Collections.sort(staff,new SalaryComparator().thenComparing(new NameComparator()));
    }
}