package lesson30.task2.DAO;

import lesson30.task2.*;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class EmployeesDAO {
    private LinkedList<Project> projects = new LinkedList<>();
    private static Set<Employee> employees = new HashSet<>();
    Employee employee1 = new Employee("f1", "l1", new Date(), Position.TEAM_LEAD,
            new Department(DepartmentType.PROGRAMMERS), projects);


    public Set<Employee> addEmployees() {


        Employee employee1 = new Employee("f1", "l1", new Date(), Position.TEAM_LEAD,
                new Department(DepartmentType.PROGRAMMERS), projects);
        Employee employee2 = new Employee("f2", "l2", new Date(), Position.DEVELOPER,
                new Department(DepartmentType.PROGRAMMERS), projects);
         Employee employee3 = new Employee("f3", "l3", new Date(), Position.DEVELOPER,
          new Department(DepartmentType.MANAGERS), projects);
        //  Employee employee4 = new Employee("f4", "l4", new Date(), Position.TEAM_LEAD,
        //   new Department(DepartmentType.FINANCE));
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        //  employees.add(employee4);

        return employees;
    }


    public Employee addProjectToEmployee(String employeeName, String projectName) throws Exception {
        LinkedList<Project> projects = new LinkedList<>();
        ProjectsDAO projectsDAO = new ProjectsDAO();
        for (Employee employee : addEmployees()) {
            if (employee != null && employee.getFirstName().equals(employeeName)) {
                projects.addAll(employee.getProjects());
                projects.add(projectsDAO.findProjectbyName(projectName));
                employee.setProjects(projects);
                return employee;
            }
        }
        throw new Exception("ERROR");
    }

    public Set<Employee> getEmployees() {
        return employees;

    }

    public Employee findByName(String name) throws Exception {
        for (Employee employee : getEmployees()) {
            if (employee != null && employee.getFirstName().equals(name))
                return employee;
        }
        throw new Exception("name is wrong");
    }


}



