package lesson20.task2;

public class InternalServerException extends BadRequestException {
    public InternalServerException(String message) {
        super(message);
    }
}
