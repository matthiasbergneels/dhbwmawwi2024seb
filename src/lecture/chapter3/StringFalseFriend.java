package lecture.chapter3;

public class StringFalseFriend {

  public static void main(String[] args) {

    int numberA = 4;
    int numberB = 5;
    System.out.println("numberA == numberB? " + (numberA == numberB));

    String myText1 = "Hallo";
    String myText2 = "Hallo";
    String myText3 = new String("Hallo");
    String myText4 = "Welt";

    System.out.println(myText1 + " == " + myText2 + " ? " + (myText1 == myText2));
    System.out.println(myText1 + " == " + myText3 + " ? " + (myText1 == myText3));

    System.out.println(myText1 + " equals " + myText2 + " ? " + (myText1.equals(myText2)));
    System.out.println(myText1 + " equals " + myText3 + " ? " + (myText1.equals(myText3)));
    System.out.println(myText1 + " equals " + myText4 + " ? " + (myText1.equals(myText4)));

  }
}
