package lesson19.HW;


import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {


        File file = new File(1, "dfsafdsf", "txt", 2);
        File file1 = new File(2, "ffffffffff", "txt", 2);
        File file2 = new File(3, "afasfafafafa", "txt", 2);

        File file3 = new File(4, "E", "txt", 2);
        File file4 = new File(1, "E", "tx", 2);

        File[] files = {file, file1, file2, null};
        File[] files1 = {file, null, null, null, null};
        String[] format = {"txt", "doc"};
        Storage storage = new Storage(50, files, format, "Lviv", 40);  // нормально
        Storage storage1 = new Storage(50, files, format, "Lviv", 4);  // малий розмір стореджа
        Storage storage2 = new Storage(50, files, format, "Lviv", 40); // не той формат файла
        Storage storage3 = new Storage(50, files1, format, "Lviv", 40); // не той формат файла
        Controller controller = new Controller();
        //   try {
        //      System.out.println(Arrays.toString(controller.put(storage, file3)));
        //      System.out.println(Arrays.toString(controller.put(storage1, file3)));
        //     System.out.println(Arrays.toString(controller.put(storage2, file4)));

        //  } catch (Exception e) {
        //      System.err.println("error");
        //  }


        //  try {
        //      System.out.println(Arrays.toString(controller.delete(storage, file2)));
        //      System.out.println(Arrays.toString(controller.put(storage1, file4)));  // нема четвертого файла в масиві.
        //      System.out.println(Arrays.toString(controller.put(storage1, null))); // файл null
        //  } catch (Exception e) {
        //      System.out.println("error");
        //  }

        try {
          //  controller.transfer(storage, storage3);
            controller.transfer(storage, storage3);

        } catch (Exception e) {
            System.out.println("error");
        }

     controller.checkArraySize(storage, storage3);

    }

}

