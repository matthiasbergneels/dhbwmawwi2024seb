package lecture.chapter4;

public class LoopExamples {

  public static void main(String[] args) {

    int count = 0;
    System.out.println("0-9 Kopfgesteuert - while:");
    while (count < 10) {
      if(count % 2 != 0) {
        count++;
        continue;   // Alles folgende in der Schleife wird für DIESEN DURCHLAUF übersprungen
      }
      System.out.println(count);
      count++;
    }

    count = 0;
    System.out.println("0-9 Fußgesteuert - do-while:");
    do{
      if(count == 6){
        System.out.println("Alles über 5 ist böse!");
        break;    // Schleife wird abgebrochen
      }
      System.out.println(count);
      count++;
    }while(count < 10);


    System.out.println("0-9 Zählerschleife - for");
    for(int i = 0; i < 10; i++){
      System.out.println(i);
    }

    System.out.println("0-9 Zählerschleife - for (nur gerade Zahlen)");
    for(int i = 0; i < 10; i += 2){
      System.out.println(i);
    }

    System.out.println("For-Timmmmmmaaaayyyyyyyy:");
    count = 0;
    for(;;){
      System.out.println(count++);
      if(count == 10){
        break;
      }
    }

    String[] weekdays = {"Mond", "Tue", "Wed", "Thu", "Fri", "Sat"};
    System.out.println("Iterration durch ein Array mit for (Zähler):");
    for(int i = 0; i < weekdays.length; i++){
      System.out.println(weekdays[i]);
    }

    System.out.println("Iterration durch ein Array mit for-each:");
    for(String weekday : weekdays){
      System.out.println(weekday);
    }
  }


}
