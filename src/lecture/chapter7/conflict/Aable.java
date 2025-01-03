package lecture.chapter7.conflict;

public interface Aable {

  default void stupidPrint(){
    System.out.println("Aable printing!");
  }
}
