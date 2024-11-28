package lecture.chapter5;

public class Student {

  private int studentId;
  private String name;

  public Student(int studentId, String name) {
    this.studentId = studentId;
    this.name = name;
  }

  public void drink(double amount){
    System.out.println(this.name + " trinkt " + amount + " Liter");
  }

  // void drink(double, float)
  public void drink(double amount, float coffeinInMg){
    drink(amount);
    System.out.println("und wird wacher.");
  }

  public void drink(double amount, int alcoholInPercentage){
    drink(amount);
    System.out.println("und wird betrunken.");
  }

  public void drink(double amount, float coffeinInMg, int alcoholInPercentage){
    drink(amount, coffeinInMg);
    System.out.println("und wird betrunken.");
  }

  // void drink(float, double)
  public void drink(float poisonInMl, double amount){
    drink(amount);
    System.out.println(poisonInMl < 0.5 ? "wird krank." : "stirbt!");
  }

}
