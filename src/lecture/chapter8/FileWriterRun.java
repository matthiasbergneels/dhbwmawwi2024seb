package lecture.chapter8;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterRun {

  public static void main(String[] args){
    FileWriter datei = null;
    String text;

    try {
      datei = new FileWriter("ausgabe.txt");
      text = "1\n";

      for (int i = 2; i <= 100; i++) {
        text += i;
        text += "\n";
      }

      datei.write(text, 0, text.length());
      datei.flush();

    }catch(IOException exception){
      System.out.println(exception.getMessage());
      System.out.println("Problem beim schreiben der Datei");
    }finally {
      try {
        datei.close();
      }catch(IOException exception){
        System.out.println("Problem beim schließen der Datei");
      }
    }
  }
}