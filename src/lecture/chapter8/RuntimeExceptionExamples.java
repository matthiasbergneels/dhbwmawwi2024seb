package lecture.chapter8;

public class RuntimeExceptionExamples {
  public static void main(String[] args) {

    String text = null;

    System.out.println(text);

    /*
    try {
      System.out.println(text.length());
    }catch(NullPointerException exception) {
      System.out.println("Kein String vorhanden");
    }
     */

    if(text != null) {
      System.out.println(text.length());
    }else {
      System.out.println("Kein String vorhanden");
    }

    String[] texts = {"Hallo", "Eins", "Drei"};

    for(int i = 0; i < texts.length;  i++){
      try {
        System.out.println(texts[i]);
      }catch(IndexOutOfBoundsException exception) {
        System.out.println("Element " + i + " nicht vorhanden");
      }
    }

    int a = 5;
    int b = 0;

    /*
    try {
      int result = a / b;
      System.out.println(result);
    }catch(ArithmeticException exception) {
      System.out.println(exception.getMessage());
    }

     */

    // OOOOOOOODER...
    if(b != 0){
      int result = a / b;
      System.out.println(result);
    } else {
      System.out.println("Division durch 0 nicht erlaubt");
    }

  }
}
