package lecture.chapter7.conflict;

public class Conflicting implements Aable, Bable{

  @Override
  public void stupidPrint() {   // --> muss implementiert werden um den Konflikt aus den Interfaces aufzulösen
    Aable.super.stupidPrint();
    System.out.println("Conflicting printing!");
    Bable.super.stupidPrint();
  }
}
