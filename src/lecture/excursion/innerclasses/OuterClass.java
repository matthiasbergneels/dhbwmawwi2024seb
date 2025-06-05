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

    innerAnonymousClass.printMessage(message);

  }


  public static void main(String[] args) {

    String message = "unsere tolle Nachricht durch die Klassen!";
    OuterClass outerClass = new OuterClass(42);
    OuterClass secondOuterClassObject = new OuterClass(13);

    outerClass.printMessage(message);

    OuterClass.InnerTopLevelClass innerTopLevelClass = new OuterClass.InnerTopLevelClass();
    innerTopLevelClass.printMessage(message);

    OuterClass.InnerElementClass innerElementClass = outerClass.new InnerElementClass();
    innerElementClass.printMessage(message);

    OuterClass.InnerElementClass secondInnerElementClass = secondOuterClassObject.new InnerElementClass();
    secondInnerElementClass.printMessage(message);

    OuterClass.printMessageFromInnerLocalClass(message);
    OuterClass.printMessageFromSecondInnerLocalClass(message);

    OuterClass.printFromAnonymusInnerClass(message);
  }
}
