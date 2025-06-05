package lecture.chapter8;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterRunARM {

    public static void main(String[] args){
      String text;

      // try-with-Ressource (ARM)
      try(FileWriter datei = new FileWriter("ausgabe.txt")) {
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
      }
    }
  }