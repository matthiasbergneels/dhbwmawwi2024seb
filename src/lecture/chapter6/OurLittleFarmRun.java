package lecture.chapter6;

public class OurLittleFarmRun {

  public static void main(String[] args) {

    Animal myAnimal = new Animal("Fridolon", 10, 100);

    System.out.println("Mit myAnimal interagieren:");
    myAnimal.move();
    myAnimal.eat();
    myAnimal.breath();

    Dog myDog = new Dog("Hasso", 5, 30, "Dackel");

    System.out.println("Mit myDog interagieren:");
    myDog.move();
    myDog.breath();
    myDog.eat();
    myDog.bark();

  }
}
