package lesson30.task2.DAO;

import lesson30.task2.Department;
import lesson30.task2.DepartmentType;
import lesson30.task2.Employee;


import java.util.LinkedList;


public class DepartmensDAO {
    private EmployeesDAO employeesDAO = new EmployeesDAO();

    public LinkedList<Department> getDepartments() {
        LinkedList<Department> departments = new LinkedList<>();
        Department department1 = new Department(DepartmentType.PROGRAMMERS);
        Department department2 = new Department(DepartmentType.MANAGERS);
        Department department3 = new Department(DepartmentType.FINANCE);

        departments.add(department1);
        departments.add(department2);
        departments.add(department3);

        return departments;
    }


    public LinkedList<Employee> getEmployeesInDep(DepartmentType departmentType) throws  Exception {
        LinkedList<Employee> employees = new LinkedList<>();
        for (Employee employee : employeesDAO.getEmployees()){
            if (employee != null && employee.getDepartment().getType().equals(departmentType))
                employees.add(employee);
        }
        return employees;

    }
}