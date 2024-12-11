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
  @Override
  public void eat(){
    super.eat();
    System.out.println("- Hunde fressen Fleisch");
  }

  @Override
  public void breath() {
    System.out.println("Der Hund " + getDescription() + " atment!");
  }

  // Überladene Methode
  public void eat(float amount){
    this.eat();
    System.out.println("- Menge: " + amount + " kg.");
  }

  /* --> final -> kann nicht überschrieben werden
  public void move(){
    System.out.println("Der Hund " + getDescription() + " bewegt sich"!");
  }
  */

  public void move(int km){
    System.out.println("Der Hund " + getDescription() + " bewegt sich " + km + " km.");
  }


  @Override
  public String toString() {
    return super.toString() + " und ist ein Hund der Rasse " + breed;
  }

  public void visibilityExample(){
    // System.out.println(description); --> private
    System.out.println(packagePrivate);
    System.out.println(inheritancePrivate);
  }
}
