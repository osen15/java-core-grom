package lesson33;

public class Demo {

    public static void main(String[] args) throws Exception {
        ReadWriteFile readWriteFile = new ReadWriteFile();



     readWriteFile.readFile("C:/Test.txt");
     readWriteFile.writeFile("C:/Test1.txt");

    }
}
