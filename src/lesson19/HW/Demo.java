package lesson19.HW;


import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {


        File file = new File(1, "ddsf", "txt", 2);
        File file1 = new File(2, "ff", "doc", 2);
        File file2 = new File(7, "af", "txt", 2);

        File file3 = new File(8, "E", "txt", 2);
        File file4 = new File(6, "E", "txt", 2);

        File[] files = {null, file1, file};
        File[] files1 = {file1, null, null, null};

        String[] format = {"txt", "doc"};
        Storage storage = new Storage(50, files, format, "Lviv", 40);  // нормально
        Storage storage1 = new Storage(50, files, format, "Lviv", 4);  // малий розмір стореджа
        Storage storage2 = new Storage(50, files, format, "Lviv", 40); // не той формат файла
        Storage storage3 = new Storage(50, files1, format, "Lviv", 40); // не той формат файла
        Controller controller = new Controller();

     //   System.out.println(controller.put(storage3, file3));
     //   System.out.println(Arrays.toString(files1));
        //   System.out.println((controller.put(storage1, file3)));
        //     System.out.println(Arrays.toString(controller.put(storage2, file4)));


        //    System.out.println((controller.delete(storage, file4)));
        //    System.out.println(Arrays.toString(files));
        //      System.out.println(Arrays.toString(controller.put(storage1, file4)));  // нема четвертого файла в масиві.
        //      System.out.println(Arrays.toString(controller.put(storage1, null))); // файл null



             System.out.println(Arrays.toString(controller.transferAll(storage, storage3)));



        //     System.out.println(Arrays.toString(files1));
        // }
        //  controller.transferAll(storage, storage3);


        // controller.transferFile(storage, storage3, 1);  // помилка, файл з таким айді вже є в стореджі.
        // controller.transferFile(storage, storage3,0); // додаємо файл, коли в стореджі нема такого айді
        //  controller.transferFile(storage, storage3, 2); // неправильний формат файла
        // System.out.println(Arrays.toString(files1));


        //  System.out.println(controller.checkId(storage, file4.getId()));

    }


}
