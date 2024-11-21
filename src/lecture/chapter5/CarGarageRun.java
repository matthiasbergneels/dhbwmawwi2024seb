package lecture.chapter5;

class CarGarageRun {

  public static void main(String[] args) {
    Car myCar = new Car("Pink", "HD AB-1234", 350, "Mitubishi");

    /*
    myCar.color = "Pink";
    myCar.brand = "Mitsubishi";
    myCar.hp = 350;
   */

    Car yourCar = new Car("kack braun", "MA HH-6728", 250, "Mercedes");

    /*
    yourCar.color = "Schwarz";
    yourCar.brand = "Mercedes";
    yourCar.hp = 250;
     */

    Car hisCar = new Car(null, null, 0, null);

    /*
    System.out.println("Mein Auto ist ein " + myCar.brand + " in " + myCar.color + " mit " + myCar.hp + " PS. Aktuelle Geschwindigkeit " + myCar.currentSpeed + " km/h");
    System.out.println("Dein Auto ist ein " + yourCar.brand + " in " + yourCar.color + " mit " + yourCar.hp + " PS. Aktuelle Geschwindigkeit " + myCar.currentSpeed + " km/h");
    System.out.println("Sein Auto ist ein " + hisCar.brand + " in " + hisCar.color + " mit " + hisCar.hp + " PS. Aktuelle Geschwindigkeit " + hisCar.currentSpeed + " km/h");
     */

    myCar.printCarDetails();
    yourCar.printCarDetails();
    hisCar.printCarDetails();

    myCar.accelerate(45);
    myCar.accelerate(35);
    System.out.println("Mein Auto fährt gerade " + myCar.getCurrentSpeed() + " km/h");
    System.out.println("Dein Auto fährt gerade " + yourCar.getCurrentSpeed() + " km/h");
    myCar.brake();
    myCar.brake();
    myCar.brake();
    System.out.println("Mein Auto fährt gerade " + myCar.getCurrentSpeed() + " km/h");
    System.out.println("Dein Auto fährt gerade " + yourCar.getCurrentSpeed() + " km/h");

    /* --> Sichtbarkeit auf private gesetzt!
    myCar.color = "kack braun";
    myCar.currentSpeed = Integer.MAX_VALUE;
    yourCar.brand = "Fiat";
    */

    myCar.printCarDetails();
    yourCar.printCarDetails();

  }
}
