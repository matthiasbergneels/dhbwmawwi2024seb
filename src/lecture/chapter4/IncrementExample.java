package lecture.chapter4;

public class IncrementExample {

  public static void main(String[] args) {
    int numberA;
    int numberB;
    numberA = 50;
    numberB = 50;
    int result = ++numberA + numberA + numberB;       // ??? Warum 26? --> 28
    System.out.println(result);
  }
}
