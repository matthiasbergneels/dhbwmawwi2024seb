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

  // Überschreiben
  public void eat(){
    super.eat();
    System.out.println("- Hunde fressen Fleisch");
  }

  // Überladene Methode
  public void eat(float amount){
    this.eat();
    System.out.println("- Menge: " + amount + " kg.");
  }

}
