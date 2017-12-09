package lesson35.service.utils;

public class IDGenerate {
    public static long generateID() {
        return (long) (Math.random() * 2147483647);
    }
}
