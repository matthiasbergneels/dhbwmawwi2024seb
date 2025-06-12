package lecture.excursion.innerclasses;


public class OuterClass {

  public static interface Printable{
    void printMessage(String message);
  }

  // Inner Top Level Class
  public static class InnerTopLevelClass{

    public void printMessage(String message){
      System.out.println("Nachricht von: " + this.getClass().getName() + " - " + message + " / Class Id: " + outerClassId);
    }
  }

  // Inner Element Class
  public class InnerElementClass{
    public void printMessage(String message){
      System.out.println("Nachricht von: " + this.getClass().getName() + " - " + message + " / Object Id: " + outerClassObjectId);
    }
  }

  private int outerClassObjectId;
  private static int outerClassId = 4711;

  public OuterClass(int outerClassObjectId){
    this.outerClassObjectId = outerClassObjectId;
  }

  public void printMessage(String message){
    System.out.println("Nachricht von: " + this.getClass().getName() + " - " + message);
  }

  public static void printMessageFromInnerLocalClass(String message){

    class InnerLocalClass{

      public void printMessage(String message){
        System.out.println("Nachricht von: " + this.getClass().getName() + " - " + message + " / Class Id: " + outerClassId);
      }

    }
    InnerLocalClass innerLocalClass = new InnerLocalClass();
    innerLocalClass.printMessage(message);
  }

  public static void printMessageFromSecondInnerLocalClass(String message){

    class InnerLocalClass {

      public void printMessage(String message){
        System.out.println("Nachricht von: " + this.getClass().getName() + " - " + message + " / Class Id: " + outerClassId);
      }

    }

    InnerLocalClass innerLocalClass = new InnerLocalClass();
    innerLocalClass.printMessage(message);
  }

  public static void printFromAnonymusInnerClass(String message){

    Printable innerAnonymousClass = new Printable(){
      public void printMessage(String message){
        System.out.println("Nachricht von: " + this.getClass().getName() + " - " + message + " / Class Id: " + outerClassId);
      }
    };

    Object objectImplementation = new Object(){ // anonymousClass extends Object

      private String memeberText = "Test";

      // Methode ist nicht von außen aufrufbar
      public void printMessage(String message){
        System.out.println(message);
      }

      public String toString(){
        return "Meine Message aus der anonymen Klasse " + memeberText;
      }
    };

    System.out.println(objectImplementation);

    System.out.println(innerAnonymousClass.toString());
    innerAnonymousClass.printMessage(message);
  }

  public static void printMessageFromLambda(String message){

    Printable lambdaFunction = (lambdaMessage)->{System.out.println("Nachricht von: LambdaFunktion - " + message + " / Class Id: " + outerClassId);};

    // ( Eingabeparameter ... )->Anweisung;
    // ( Eingabeparameter ... )->{Anweisung1; Anweisung2; Anweisung3 };
    // input->Anweisung;
    // (input)->{Anweisung};

    System.out.println(lambdaFunction.toString());
    System.out.println(lambdaFunction.hashCode());
    lambdaFunction.printMessage(message);
  }


  public static void main(String[] args) {

    String message = "unsere tolle Nachricht durch die Klassen!";
    OuterClass firstOuterClassInstance = new OuterClass(42);
    OuterClass secondOuterClassInstance = new OuterClass(13);

    firstOuterClassInstance.printMessage(message);

    OuterClass.InnerTopLevelClass innerTopLevelClass = new OuterClass.InnerTopLevelClass();
    innerTopLevelClass.printMessage(message);

    OuterClass.InnerElementClass innerElementClass = firstOuterClassInstance.new InnerElementClass();
    innerElementClass.printMessage(message);

    OuterClass.InnerElementClass secondInnerElementClass = secondOuterClassInstance.new InnerElementClass();
    secondInnerElementClass.printMessage(message);

    OuterClass.printMessageFromInnerLocalClass(message);
    OuterClass.printMessageFromSecondInnerLocalClass(message);

    OuterClass.printFromAnonymusInnerClass(message);

    OuterClass.printMessageFromLambda(message);
  }
}
