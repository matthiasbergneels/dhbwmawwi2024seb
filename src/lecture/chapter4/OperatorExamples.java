package lecture.chapter4;

public class OperatorExamples {

  public static void main(String[] args) {

    int numberA = 9;
    int numberB = 5;
    double numberC = 3.0;

    int result;

    result = numberA % numberB;   // 9 % 5

    double doubleResult = numberA % numberC;
    System.out.println(doubleResult);

    System.out.println(result);

    // Inkrement & Dekrement
    numberA++;    // numberA = numberA + 1;

    ++numberA;    // numberA = 1 + numberA;

    numberA = 10;
    numberB = 5;
    System.out.println("numberA: " + numberA);    // 11
    System.out.println("numberB: " + numberB);    // 5
    result = numberA++ + numberA + numberB;       // ??? Warum 26? --> 28
    System.out.println(result);
    System.out.println("numberA: " + numberA);   // 12
    System.out.println("numberB: " + numberB);   // 5

    System.out.println(numberA == numberB);     // --> false
    System.out.println(numberA != numberB);     // --> true


    // Brauche ich einen Regenschirm?
    boolean isRaining = true;
    boolean hasToLeaveHome = false;

    boolean needUmbrella = hasToLeaveHome && isRaining;
    System.out.println("Regenschirm? " + needUmbrella);

    // Kann ich aufhören zu laufen?
    double runningDistanceInKm = 9.8;
    double runningTimeInHours = 0.8;

    double targetDistanceInKm = 10;
    double targetTimeInHours = 1.0;

    boolean canStopRunning = (runningTimeInHours >= targetTimeInHours) || (runningDistanceInKm >= targetDistanceInKm);
    System.out.println(canStopRunning);


    // Zuweisungsoperatoren - Kurzschreibweise
    numberA += numberB;   // numberA = numberA + numberB;

    // Fragezeichen Operator
    System.out.println("Brauche ich einen Regenschirm? " + (needUmbrella ? "Ja" : "Nein") );
    System.out.println("Welche Zahl ist Größer? " + ((numberA > numberB) ? numberA : numberB));

    System.out.print("Brauche ich einen Regenschirm? ");
    if(needUmbrella){
      System.out.println("Ja");
    } else {
      System.out.println("Nein");
    }

    // Zeichenketten-Verkettung --> +
    String text1 = "Hallo";
    String text2 = "Klaus";

    String resultText = numberB + numberA + text1 + " " + text2 + numberA + numberB;
    System.out.println(resultText);
  }
}
