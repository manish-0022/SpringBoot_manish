package com.SthumbhManish.demo.controllerExample;

public class Employee {

    private String name;
    private String age;

    private String salary;

    private String Address;

    public Employee(String name, String age, String salary, String address) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        Address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", salary='" + salary + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
