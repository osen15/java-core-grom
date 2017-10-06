package lesson30.task2;

import java.util.Date;
import java.util.LinkedList;

public class Employee {
    private String firstName;
    private String lastName;
    private Date dateHired;
    private Position position;
    private Department department;
    private LinkedList<Project> projects;


    public Employee(String firstName, String lastName, Date dateHired, Position position, Department department,  LinkedList<Project> projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateHired = dateHired;
        this.position = position;
        this.department = department;
        this.projects = projects;
    }

    public String getFirstName() {
        return firstName;
    }

    public LinkedList<Project> getProjects() {
        return projects;
    }

    public Position getPosition() {
        return position;
    }

    public void setProjects(LinkedList<Project> projects) {
        this.projects = projects;
    }

    public Department   getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateHired=" + dateHired +
                ", position=" + position +
                ", department=" + department +
                ", projects=" + projects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return firstName != null ? firstName.equals(employee.firstName) : employee.firstName == null;
    }

    @Override
    public int hashCode() {
        return firstName != null ? firstName.hashCode() : 0;
    }
}
