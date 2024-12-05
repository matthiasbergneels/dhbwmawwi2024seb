package lecture.chapter6;

public class Dog extends Animal {

  private String breed;

  public Dog(String description, float weight, float size, String breed){
    super(description, weight, size);
    this.breed = breed;
  }

  public void bark(){
    System.out.println("Der Hund " + getDescription() + " bellt.");
  }

}
