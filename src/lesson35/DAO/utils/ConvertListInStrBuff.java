package lesson35.DAO.utils;

import java.util.ArrayList;

public class ConvertListInStrBuff {
    public static <T> StringBuffer listInStrBuff(ArrayList<T> ts) throws Exception {
        StringBuffer stBuff = new StringBuffer();
        for (T t : ts) {
            stBuff.append(t.toString()).append("\r\n");


        }
        return stBuff;
    }
}