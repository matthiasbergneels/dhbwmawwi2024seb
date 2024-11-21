package lecture.chapter5;

public class Car {

  // Attribute / Members / Instanzattribute
  String color;
  String licensePlateNumber;
  int hp;
  String brand;
  double currentSpeed;

  void accelerate(double deltaSpeed){
    if(currentSpeed > 0 && deltaSpeed < 50){
      currentSpeed += deltaSpeed;
    }
  }

  void brake(){
    if(currentSpeed >= 5){
      currentSpeed -= 5;
    } else {
      currentSpeed = 0;
    }
  }

  void fullBrake(){
    currentSpeed = 0;
  }

}
