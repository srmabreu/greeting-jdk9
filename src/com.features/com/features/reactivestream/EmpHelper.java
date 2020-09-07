package com.features.reactivestream;

import java.util.List;

public class EmpHelper {

    public static List<Employee> getEmps() {
        return List.of(new Employee(1, "Pankaj"),
                new Employee(2, "David"),
                new Employee(3, "Lisa"),
                new Employee(4, "Ram"),
                new Employee(5, "Anupam"));
    }

}
