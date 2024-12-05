package lecture.chapter6;

public class Animal {

  private String description;
  private float size;
  private float weight;

  public Animal(String description, float size, float weight) {
    this.description = description;
    this.size = size;
    this.weight = weight;
  }

  public void move(){
    System.out.println("Das Tier " + description  + " bewegt sich.");
  }

  public void eat(){
    System.out.println("Das Tier " + description  + " frisst.");
  }

  public void breath(){
    System.out.println("Das Tier " + description  + " atmet.");
  }

  public String getDescription() {
    return description;
  }

  public float getSize() {
    return size;
  }

  public float getWeight() {
    return weight;
  }
}
