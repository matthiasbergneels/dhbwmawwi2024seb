package lecture.chapter3;

public class SimpleDataTypeConversion {

  public static void main(String[] args) {

    byte numberB = 10;
    int numberA;
    float numberC;
    double numberD;

    // Implizite Typenkonvertierung
    System.out.println(numberB);
    numberA = numberB;
    System.out.println(numberA);
    numberC = numberA;
    System.out.println(numberC);
    numberD = numberC;
    System.out.println(numberD);

    numberD = numberB;

    // Explizite Typkonvertierung mit Type-Cast-Operator
    // Float zu Double konvertieren
    numberD = 255.567;
    System.out.println(numberD);
    numberC = (float)numberD;
    System.out.println(numberC);
    numberA = (int)numberC;
    System.out.println(numberA);
    numberB = (byte)numberA;
    System.out.println(numberB);


    // Char

    char firstSign = 'B';
    firstSign = 67;

    int firstSignCodeValue = firstSign;

    System.out.println(firstSign);
    System.out.println(firstSignCodeValue);
  }
}
