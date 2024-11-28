package lecture.chapter5;

public class Person {

  private String name;
  private boolean hasBlackEye;

  public Person(String name) {
    this.name = name;
    this.hasBlackEye = false;
  }

  public void punchPerson(){
    hasBlackEye = true;
  }

  public boolean hasBlackEye() {
    return hasBlackEye;
  }
  public String getName() {
    return name;
  }
}
