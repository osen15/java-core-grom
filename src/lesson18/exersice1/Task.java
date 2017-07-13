package lesson18.exersice1;



public class Task {
    public static void main(String[] args) {
        FileStorage fileStorage = new FileStorage();
        CodeStorage codeStorage = new CodeStorage();
        PictureStorage pictureStorage = new PictureStorage();

        String[] fileName1 = {"1", "2"};
        String[] fileName2 = {"a", "b", "c"};
        String[] fileName3 = {"1", "W", "rt", "w", "e"};

        fileStorage.setFiles(fileName1);
        codeStorage.setFiles(fileName2);
        pictureStorage.setFiles(fileName3);

        System.out.println("Start printing name...");
        printer(fileStorage);
        printer(codeStorage);
        printer(pictureStorage);
        System.out.println("Done");

    }

    public static void printer(Storage storage) {
        String[] names = storage.getFiles();

        try {
            System.out.println("5th name is " + names[4]);
        } catch (Exception e) {
            System.err.println("5h name can be not found...");
            // System.err.println(e.getMessage());
        }

    }


}
