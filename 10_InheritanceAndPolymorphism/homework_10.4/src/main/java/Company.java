package main.java;

import java.util.HashMap;
import java.util.TreeMap;

public class Company {

    enum positionList { Manager, TopManager, Operator }
    public static int incomOfCompany;

    HashMap<String, String> employeesList = new HashMap<>();


    public void hire(String name, String position){
    employeesList.put(name,position);
    }

    public void hireAll{

    }

    public void fire{

    }


    получение значения дохода компании – getIncome().
}
