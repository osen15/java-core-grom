package lesson35.service.utils;

import java.util.Random;

public class IDGenerate {
    public static long generateID() {
        return  new Random().nextLong();
    }
}
