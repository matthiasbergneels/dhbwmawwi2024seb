package lecture.chapter5.subpackage;

import lecture.chapter5.Car;

public class CarGarageRun {
  public static void main(String[] args) {
    Car subpackageCar = new Car("Rot", "HD MM-8729", 150, "Opel");

    // accelerate --> default / package-private
    // subpackageCar.accelerate(17);
    // subpackageCar.accelerate(20);
    subpackageCar.fullBrake();

    // printCarDetails --> protected
    //subpackageCar.printCarDetails();
  }
}
