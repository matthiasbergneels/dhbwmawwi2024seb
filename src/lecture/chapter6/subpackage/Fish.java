package lecture.chapter6.subpackage;

import lecture.chapter6.Animal;

public class Fish extends Animal {

  public Fish(String description, float size, float weight) {
    super(description, size, weight);
  }

  @Override
  public void breath() {

  }

  public void visibilityExample(){
    // System.out.println(description); --> private
    // System.out.println(packagePrivate); --> default
    System.out.println(inheritancePrivate);
  }
}
