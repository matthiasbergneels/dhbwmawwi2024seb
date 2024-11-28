package lecture.chapter5;

public class Car {

  // Attribute / Members / Instanzattribute
  private String color;
  private String licensePlateNumber;
  private int hp;
  public final CarBrand brand;
  private double currentSpeed;

  // Klassenattribute
  private static int carCount;

  // Initialisierungs Block - Klassenkonstruktor - wird EINMAL für die Klasse aufgerufen
  static{
    // Lese aktuelle Anzahl aus Datenbank aus
    carCount = 0;
  }


  // Konstruktoren

  // Initialisierungsblock für Objekte
  {
    // Läuft vor JEDEM Konstruktor Aufruf
    // ...
  }

  public Car(String color, String licensePlateNumber, int hp, CarBrand brand){
    this.setColor(color);
    this.setLicensePlateNumber(licensePlateNumber);
    this.setHp(hp);
    this.brand = (brand != null) ? brand : CarBrand.FIAT;

    currentSpeed = 0.0;
    carCount++;
  }

  // (Instanz-)Methoden
  void accelerate(double deltaSpeed){
    if(deltaSpeed > 0 && deltaSpeed < 50){
      currentSpeed += deltaSpeed;
    }
  }

  public void brake(){
    if(currentSpeed >= 5){
      currentSpeed -= 5;
    } else {
      currentSpeed = 0;
    }
  }

  public void fullBrake(){
    currentSpeed = 0;
  }

  protected void printCarDetails(){
    System.out.println("Mein Auto ist ein " + brand + " (Preissegment: " + brand.getPriceTag() + ") in " + color + " mit " + hp + " PS. Aktuelle Geschwindigkeit " + currentSpeed + " km/h");
  }

  // Getter / Setter
  public String getColor(){
    return color;
  }

  public String getLicensePlateNumber(){
    return licensePlateNumber;
  }

  public int getHp(){
    return hp;
  }

  public CarBrand getBrand(){
    return brand;
  }

  public double getCurrentSpeed(){
    return currentSpeed;
  }


  public void setColor(String color){
    // Plausibilitätsprüfung
    if(color != null && (color.equals("Pink") || color.equals("Schwarz") || color.equals("Rot") || color.equals("Blau") || color.equals("Grau"))){
      this.color = color;
    } else {
      this.color = "Grau";
    }
  }

  public void setHp(int hp){
    if(hp > 50 && hp < 800){
      this.hp = hp;
    } else {
      this.hp = 100;
    }
  }

  public void setLicensePlateNumber(String licensePlateNumber){
    this.licensePlateNumber = licensePlateNumber;
  }

  // Klassenmethoden
  public static int getCarCount(){
    return carCount;
  }

  protected void finalize(){
    System.out.println("Das Auto von der Marke " + this.brand + " in der Farbe " + this.color + " wird verschrottet");
    carCount--;
  }
}
