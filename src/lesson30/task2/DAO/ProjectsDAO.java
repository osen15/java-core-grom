package lesson30.task2.DAO;

import lesson30.task2.Customer;
import lesson30.task2.Project;

import java.util.ArrayList;


public class ProjectsDAO {
    private static ArrayList<Project> projects = new ArrayList<>();

    public ArrayList<Project> addProgects() {

        Project project1 = new Project("123", new Customer("123", "USA", 10000));
        Project project2 = new Project("124", new Customer("123", "USA", 20000));
        Project project3 = new Project("125", new Customer("654", "Germany", 30000));

        projects.add(project1);
        projects.add(project2);
        projects.add(project3);

        return projects;
    }

    public Project findProjectbyName(String projectName) throws Exception {
        for (Project project : addProgects()) {
            if (project != null && project.getName().equals(projectName))
                return project;
        }
        throw new Exception("project with this name was not found");

    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

}
