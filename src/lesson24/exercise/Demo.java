package lesson24.exercise;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        GeneralDAO<Sys> systemDAO = new GeneralDAO<>();
        Sys system = new Sys(11, "...");
        systemDAO.save(system);


        System.out.println(Arrays.deepToString(systemDAO.getAll()));

        systemDAO.save(system);

        System.out.println(Arrays.deepToString(systemDAO.getAll()));


        GeneralDAO<Tool> toolDAO = new GeneralDAO<>();
        Tool tool = new Tool("rrr", "ppp");
        toolDAO.save(tool);

        System.out.println(Arrays.deepToString(toolDAO.getAll()));

        toolDAO.save(tool);

        System.out.println(Arrays.deepToString(toolDAO.getAll()));




    }















}
