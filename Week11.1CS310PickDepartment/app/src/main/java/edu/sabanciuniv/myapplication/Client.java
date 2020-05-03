package edu.sabanciuniv.myapplication;

import java.io.Serializable;

public class Client implements Serializable {
    private String name;
    private String lastname;
    private String department;


    public Client(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;

    }

    public Client(String name, String lastname, String department) {
        this.name = name;
        this.lastname = lastname;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
