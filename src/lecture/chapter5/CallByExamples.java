package lecture.chapter5;

public class CallByExamples {

  public static void main(String[] args) {

    // Call by Value
    int numberA = 5;
    int numberB;

    numberB = numberA;

    numberA = numberA + 10;

    System.out.println(numberA);
    System.out.println(numberB);

    // Call by Reference
    Person herrBergNeels = new Person("Matthias");
    Person herrProfDrHoley = new Person("Thomas");

    Person papa =  herrBergNeels;
    Person schnurziPups = papa;

    schnurziPups.punchPerson();

    System.out.println("Herr Berg-Neels hat ein blaues Auge? " + herrBergNeels.hasBlackEye());
    System.out.println("Herr Herr Prof. Dr. Holey hat ein blaues Auge? " + herrProfDrHoley.hasBlackEye());

  }

}
