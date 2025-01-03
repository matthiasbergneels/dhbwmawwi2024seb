package lecture.chapter7.conflict;

public interface Bable {

  default void stupidPrint(){
    System.out.println("Bable printing!");
  }
}
