package lesson20.task2.exeption;

public class LimitExceeded extends Exception {
    public LimitExceeded(String message) {
        super(message);
    }
}
