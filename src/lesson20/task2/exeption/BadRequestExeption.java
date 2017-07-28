package lesson20.task2.exeption;

public class BadRequestExeption extends  Exception {
    public BadRequestExeption(String message) {
        super(message);
    }
}
