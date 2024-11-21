package lecture.chapter5;

public class CarGarageRun {

  public static void main(String[] args) {
    Car myCar = new Car();

    myCar.color = "Pink";
    myCar.brand = "Mitsubishi";
    myCar.hp = 350;

    Car yourCar = new Car();

    yourCar.color = "Schwarz";
    yourCar.brand = "Mercedes";
    yourCar.hp = 250;

    Car hisCar = new Car();

    System.out.println("Mein Auto ist ein " + myCar.brand + " in " + myCar.color + " mit " + myCar.hp + " PS. Aktuelle Geschwindigkeit " + myCar.currentSpeed + " km/h");
    System.out.println("Dein Auto ist ein " + yourCar.brand + " in " + yourCar.color + " mit " + yourCar.hp + " PS. Aktuelle Geschwindigkeit " + myCar.currentSpeed + " km/h");
    System.out.println("Sein Auto ist ein " + hisCar.brand + " in " + hisCar.color + " mit " + hisCar.hp + " PS. Aktuelle Geschwindigkeit " + hisCar.currentSpeed + " km/h");


  }
}
