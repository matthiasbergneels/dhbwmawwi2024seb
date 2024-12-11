package lecture.chapter6;

public final class Bird extends Animal {

  private boolean canFly;

  public Bird(String description, float size, float weight, boolean canFly) {
    super(description, size, weight);
    this.canFly = canFly;
  }

  public void tweet(){
    System.out.println("Der Vogel " + this.getDescription() + " zwitschert.");
  }

  @Override
  public void breath() {
    System.out.println("Der Vogel " + this.getDescription() + " atmet.");
  }
}
