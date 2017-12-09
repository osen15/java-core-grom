package lesson35.DAO.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReWriteFile {


    public static <T> void reWriteFile(ArrayList<T> ts, String fileName) throws Exception {
        ConvertListInStrBuff.listInStrBuff(ts);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false))) {

            bw.append(ConvertListInStrBuff.listInStrBuff(ts).toString());
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Can't write to fileDB");
        }


    }


}






