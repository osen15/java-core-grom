package lesson30.task2;

import lesson30.task2.DAO.CustomersDAO;
import lesson30.task2.DAO.DepartmensDAO;
import lesson30.task2.DAO.EmployeesDAO;
import lesson30.task2.DAO.ProjectsDAO;

public class Demo {
    public static void main(String[] args) throws Exception {
        CustomersDAO customersDAO = new CustomersDAO();
        //  System.out.println(customersDAO.getCustomers());  // база даних кастомерс
         EmployeesDAO employeesDAO = new EmployeesDAO();
        //System.out.println(employeesDAO.getEmployees()); // база працівників

        ProjectsDAO projectsDAO = new ProjectsDAO();
        System.out.println(projectsDAO.addProgects());  //база всіх проектів
        // System.out.println(projectsDAO.findProjectbyName("123"));  // пошук проекта за іменем


        DepartmensDAO departmensDAO = new DepartmensDAO();
        //  System.out.println(departmensDAO.getDepartments()); // база департаментів

        //  System.out.println(departmensDAO.getEmployeesInDep(DepartmentType.PROGRAMMERS));  // База людей в департаменті програмістів


          System.out.println(employeesDAO.addProjectToEmployee("f1", "123")); // Закріплення проекту за працівником
          System.out.println(employeesDAO.addProjectToEmployee("f2", "123"));
          System.out.println(employeesDAO.addProjectToEmployee("f3", "123"));
          System.out.println(employeesDAO.getEmployees());
        customersDAO.addCustomers();


        Controller controller = new Controller();
        //   System.out.println(controller.employeesByProject(projectsDAO.findProjectbyName("123")));

        //   System.out.println(controller.projectsByEMployee(employeesDAO.findByName("f1")));

        //  System.out.println(controller.employeesByDepartmentWithoutProject(new Department(DepartmentType.PROGRAMMERS)));

        //  System.out.println(controller.employeesWithoutProject());

        // System.out.println(controller.employeesByTeamLead(employeesDAO.findByName("f1")));

        // System.out.println(controller.teamLeadsByEmployee(employeesDAO.findByName("f2")));

        // System.out.println(controller.employeesByProjectEmployee(employeesDAO.findByName("f2")));

        // System.out.println(controller.projectsByCustomer(customersDAO.findByName("123")));

        System.out.println(controller.employeesByCustomerProjects(customersDAO.findByName("123")));

    }
}
