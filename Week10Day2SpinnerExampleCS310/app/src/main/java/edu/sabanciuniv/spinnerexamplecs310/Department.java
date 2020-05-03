package edu.sabanciuniv.spinnerexamplecs310;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private int id;
    private String name;

    public Department() {
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {

        return name;


    }

    public static List<Department> getAllDepartments(){

        List<Department> depts = new ArrayList<>();

        Department dept1 = new Department(1,"IT");
        Department dept2 = new Department(2,"SALES");
        Department dept3 = new Department(3,"ACCOUNTING");
        Department dept4 = new Department(4,"OPERATIONS");

        depts.add(dept1);
        depts.add(dept2);
        depts.add(dept3);
        depts.add(dept4);



        return depts;
    }

}
