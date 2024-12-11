package lecture.chapter6;

public abstract class Animal {

  private String description;
  private float size;
  private float weight;
  String packagePrivate;
  protected String inheritancePrivate;

  public Animal(String description, float size, float weight) {
    this.description = description;
    this.size = size;
    this.weight = weight;

    packagePrivate = description + "PackagePrivate";
    inheritancePrivate = description + "InheritancePrivate";
  }

  final public void move(){
    System.out.println("Das Tier " + description  + " bewegt sich.");
  }

  public void eat(){
    System.out.println("Das Tier " + description  + " frisst.");
  }

  public abstract void breath();

  public String getDescription() {
    return description;
  }

  public float getSize() {
    return size;
  }

  public float getWeight() {
    return weight;
  }

  @Override
  public String toString() {
    return "Das Tier " + description + " (" + super.toString() + ") wiegt + " + weight + "kg und ist " + size + "cm groß";
  }
}
