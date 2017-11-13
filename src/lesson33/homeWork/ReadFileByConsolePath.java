package lesson33.homeWork;

import lesson33.FileRead;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReadFileByConsolePath {


 public void    readFileByConsolePath() throws  Exception{
     FileRead fileRead = new FileRead();

     System.out.println("Please, enter file path to read:");
     InputStreamReader reader = new InputStreamReader(System.in);

     BufferedReader br = new BufferedReader(reader);

     String text = br.readLine();

     fileRead.readFile(text);

     br.close();
     reader.close();











 }












}
