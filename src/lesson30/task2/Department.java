package lesson30.task2;

import java.util.LinkedList;

public class Department {
    private DepartmentType type;
    private LinkedList employees;

    public Department(LinkedList employees) {
        this.employees = employees;
    }

    public Department(DepartmentType type) {
        this.type = type;
    }

    public DepartmentType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Department{" +
                "type=" + type +
                '}';
    }
}
