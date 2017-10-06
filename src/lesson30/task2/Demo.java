package lesson30.task2;

public class Demo {
    public static void main(String[] args) throws Exception {
        CustomerDAO customerDAO = new CustomerDAO();
        //  System.out.println(customerDAO.getCustomers());  // база даних кастомерс
         EmployeeDAO employeeDAO = new EmployeeDAO();
        //System.out.println(employeeDAO.getEmployees()); // база працівників

        ProjectDAO projectDAO = new ProjectDAO();
        System.out.println(projectDAO.addProgects());  //база всіх проектів
        // System.out.println(projectDAO.findProjectbyName("123"));  // пошук проекта за іменем


        DepartmenDAO departmenDAO = new DepartmenDAO();
        //  System.out.println(departmenDAO.getDepartments()); // база департаментів

        //  System.out.println(departmenDAO.getEmployeesInDep(DepartmentType.PROGRAMMERS));  // База людей в департаменті програмістів


          System.out.println(employeeDAO.addProjectToEmployee("f1", "123")); // Закріплення проекту за працівником
          System.out.println(employeeDAO.addProjectToEmployee("f2", "123"));
          System.out.println(employeeDAO.addProjectToEmployee("f3", "123"));
          System.out.println(employeeDAO.getEmployees());
        customerDAO.addCustomers();


        Controller controller = new Controller();
        //   System.out.println(controller.employeesByProject(projectDAO.findProjectbyName("123")));

        //   System.out.println(controller.projectsByEMployee(employeeDAO.findByName("f1")));

        //  System.out.println(controller.employeesByDepartmentWithoutProject(new Department(DepartmentType.PROGRAMMERS)));

        //  System.out.println(controller.employeesWithoutProject());

        // System.out.println(controller.employeesByTeamLead(employeeDAO.findByName("f1")));

        // System.out.println(controller.teamLeadsByEmployee(employeeDAO.findByName("f2")));

        // System.out.println(controller.employeesByProjectEmployee(employeeDAO.findByName("f2")));

        // System.out.println(controller.projectsByCustomer(customerDAO.findByName("123")));

        System.out.println(controller.employeesByCustomerProjects(customerDAO.findByName("123")));

    }
}
