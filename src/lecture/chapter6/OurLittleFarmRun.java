package lecture.chapter6;

public class OurLittleFarmRun {

  public static void main(String[] args) {

    /* --> keine Objekte von abstrakten Klassen!
    Animal myAnimal = new Animal("Fridolon", 10, 100);

    System.out.println("Mit myAnimal interagieren:");
    myAnimal.move();
    myAnimal.eat();
    myAnimal.breath();
     */


    Dog myDog = new Dog("Hasso", 5, 30, "Dackel");
    Dog yourDog = new Dog("Bello", 25, 60, "Schäferhund");

    System.out.println("Mit myDog interagieren:");
    myDog.move();
    myDog.breath();
    myDog.eat();
    myDog.bark();
    myDog.eat(1.5f);

    Bird myBird = new Bird("Tweety", 0.15f, 15.3f, true);

    System.out.println("Mit myBird interagieren:");
    myBird.move();
    myBird.breath();
    myBird.eat();
    myBird.tweet();


    // System.out.println(myAnimal);
    System.out.println(myDog);
    System.out.println(yourDog.toString());
    System.out.println(myBird.toString());

    Dog walkTheDog = myDog;

    System.out.println(myDog.equals(yourDog));
    System.out.println(myDog.equals(walkTheDog));

    // Narrowing Cast
    Animal myAnimal = myDog;

    myAnimal.move();
    //myAnimal.bark();
    myAnimal.eat();

    Animal[] shelter = new Animal[4];

    // Narrowing Cast
    shelter[0] = myDog;
    shelter[1] = new Bird("Zwitschi", 0.15f, 15.3f, true);
    shelter[2] = yourDog;
    shelter[3] = myBird;

    System.out.println("Tiere am Leben halten - Tagesroutine:");
    for(Animal currentAnimal : shelter) {
      // Polymorphie --> Vielgestaltigkeit von Objekten
      System.out.println(currentAnimal);
      currentAnimal.eat();
      currentAnimal.breath();
      currentAnimal.move();

      if(currentAnimal instanceof Dog) {
        // Widening Cast
        Dog currentDog = (Dog) currentAnimal;
        currentDog.bark();
      }

      if(currentAnimal instanceof Bird currentBird) {
        currentBird.tweet();
      }

    }

  }
}
