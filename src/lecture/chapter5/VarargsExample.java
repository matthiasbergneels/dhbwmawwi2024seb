package lecture.chapter5;

public class VarargsExample {

  // void sumOfNumbers(int[] numbers)
  public static void sumOfNumbers(String type, int... numbers) {
    int sum = 0;
    for (int number : numbers) {
      sum += number;
    }
    System.out.println("Summe von " + type + ": " + sum);
  }

  /*
  public static void sumOfNumbers(){
    System.out.println("Summe: " + 0);
  }

  public static void sumOfNumbers(int numberA){
    System.out.println("Summe: " + numberA);
  }

  public static void sumOfNumbers(int numberA, int numberB){
    System.out.println("Summe: " + (numberA + numberB));
  }

  public static void sumOfNumbers(int numberA, int numberB, int numberC){
    System.out.println("Summe: " + (numberA + numberB + numberC));
  }
   */

  public static void main(String[] args) {
    sumOfNumbers("Bananen", 1);          // Gibt: "Summe: 1"
    sumOfNumbers("Autos", 1, 2, 3);    // Gibt: "Summe: 6"
    sumOfNumbers("Gute Noten");           // Gibt: "Summe: 0"
  }
}
