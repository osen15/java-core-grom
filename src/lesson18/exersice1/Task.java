package lesson18.exersice1;

import lesson18.exersice1.FileStorage;
import lesson18.exersice1.Storage;

public class Task {
    public static void main(String[] args) {
        FileStorage fileStorage = new FileStorage();
        String[] fileNames = {"name1", "name2"};
        fileStorage.setFiles(fileNames);
        System.out.println("Start printing name...");
        printer(fileStorage);
        System.out.println("Done");

        String[] fileNames1 = {"name1", "name2", "name3", "name4", "name5"};
        System.out.println("Start printing name...");
        fileStorage.setFiles(fileNames1);
        printer(fileStorage);
        System.out.println("Done");

        System.out.println("Start printing name...");
        printer(fileStorage);

        System.out.println("Done");



    }

    public static   void  printer(Storage storage){
        String[] names = storage.getFiles();

        try {
            System.out.println("5th name is " + names[4]);
        } catch (Exception e){
            System.err.println("5h name can be not found...");
           // System.err.println(e.getMessage());
        }

        // solution 2

    }



}
