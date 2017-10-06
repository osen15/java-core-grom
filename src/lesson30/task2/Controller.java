package lesson30.task2;

import lesson30.task2.DAO.DepartmensDAO;
import lesson30.task2.DAO.EmployeesDAO;
import lesson30.task2.DAO.ProjectsDAO;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Controller {
    public LinkedList<Employee> employeesByProject(Project project) throws Exception {
        if (project == null)
            throw new Exception("project is null");
        LinkedList<Employee> employees = new LinkedList<>();
        EmployeesDAO employeesDAO = new EmployeesDAO();
        for (Employee employee : employeesDAO.getEmployees()) {
            if (employee != null && employee.getProjects().contains(project)) {
                employees.add(employee);
            }
        }
        return employees;
    }

    public LinkedList<Project> projectsByEMployee(Employee employee) throws Exception {
        EmployeesDAO employeesDAO = new EmployeesDAO();
        if (employee == null)
            throw new Exception("employee can't null");
        for (Employee employee1 : employeesDAO.getEmployees()) {
            if (employee1 != null && employee1.equals(employee))
                return employee.getProjects();
        }
        throw new Exception("employee not found");
    }


    public Set<Employee> employeesByDepartmentWithoutProject(Department department) throws Exception {
        DepartmensDAO departmensDAO = new DepartmensDAO();
        Set<Employee> employees = new HashSet<>();
        for (Employee employee : departmensDAO.getEmployeesInDep(department.getType())) {
            if (employee != null && employee.getProjects().size() == 0)
                employees.add(employee);
        }
        return employees;
    }


    public Set<Employee> employeesWithoutProject() {
        Set<Employee> employees = new HashSet<>();
        EmployeesDAO employeesDAO = new EmployeesDAO();
        for (Employee employee : employeesDAO.getEmployees()) {
            if (employee != null && employee.getProjects().size() == 0)
                employees.add(employee);
        }
        return employees;
    }


    public LinkedList<Employee> employeesByTeamLead(Employee lead) throws Exception {
        LinkedList<Employee> employees = new LinkedList<>();
        EmployeesDAO employeesDAO = new EmployeesDAO();
        if (lead == null)
            throw new Exception("lead can't null");
        if (!lead.getPosition().equals(Position.TEAM_LEAD))
            throw new Exception("employee not a lead");
        for (Project project : lead.getProjects()) {
            for (Employee employee : employeesDAO.getEmployees()) {
                if (employee != null && employee.getProjects().contains(project) && !employee.equals(lead))
                    employees.add(employee);
            }
        }
        return employees;
    }


    public LinkedList<Employee> teamLeadsByEmployee(Employee employee) throws Exception {
        EmployeesDAO employeesDAO = new EmployeesDAO();
        LinkedList<Employee> employees = new LinkedList<>();
        if (employee == null)
            throw new Exception("employee can't null");
        if (employee.getPosition().equals(Position.TEAM_LEAD))
            throw new Exception("employee is TEAM_LEAD");
        for (Employee employee1 : employeesDAO.getEmployees()) {
            for (Project project : employee.getProjects()) {

                if (employee1.getPosition().equals(Position.TEAM_LEAD) && employee1.getProjects().contains(project))
                    employees.add(employee1);
            }
        }
        return employees;
    }

    public LinkedList<Employee> employeesByProjectEmployee(Employee employee) throws Exception {
        LinkedList<Employee> employees = new LinkedList<>();
        EmployeesDAO employeesDAO = new EmployeesDAO();
        if (employee == null)
            throw new Exception("employee is: " + employee);
        if (employee.getPosition().equals(Position.TEAM_LEAD))
            throw new Exception("employee is: " + employee.getPosition());

        for (Employee employee1 : employeesDAO.getEmployees()) {
            for (Project project : employee.getProjects()) {
                if (employee1 != null && project != null && !employee1.getPosition().equals(Position.TEAM_LEAD) && employee1.getProjects().contains(project))
                    employees.add(employee1);
            }
        }
        return employees;
    }

    public LinkedList<Project> projectsByCustomer(Customer customer) throws Exception {
        ProjectsDAO projectsDAO = new ProjectsDAO();
        LinkedList<Project> projects = new LinkedList<>();
        if (customer == null)
            throw new Exception("customer is: " + customer);
        for (Project project : projectsDAO.getProjects()) {
            if (project != null && project.getCustomer().equals(customer))
                projects.add(project);
        }
        return projects;
    }


    public LinkedList<Employee> employeesByCustomerProjects(Customer customer) throws Exception {
        LinkedList<Employee> employees = new LinkedList<>();
        EmployeesDAO employeesDAO = new EmployeesDAO();
        ProjectsDAO projectsDAO = new ProjectsDAO();
        if (customer == null)
            throw new Exception("customer is: " + customer);
        for (Employee employee : employeesDAO.getEmployees()) {
            for (Project project : employee.getProjects()) {
                if (project != null && employee != null && project.getCustomer().equals(customer))
                    employees.add(employee);
            }
        }
        return employees;
    }


}