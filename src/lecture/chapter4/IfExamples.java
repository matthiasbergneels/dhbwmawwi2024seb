package lecture.chapter4;

public class IfExamples {

  public static void main(String[] args) {

    boolean isRaining = false;

    if(isRaining) {
      System.out.println("Regenschirm mitnehmen.");
      System.out.println("Immer dieses miese Wetter!");
    } else {
      System.out.println("juhu - Sonne!!!");
    }


    int currentSpeedInKmh = 29;

    if (currentSpeedInKmh > 60) {
      System.out.println("FÜHRERSCHEIN WEG!!!");
    }else if(currentSpeedInKmh >= 0 && currentSpeedInKmh <= 30){
      System.out.println("Sehr angemessen in der Ortschaft");
    } else if(currentSpeedInKmh > 30 && currentSpeedInKmh <= 50){
      System.out.println("Ist ok in der Ortschaft");
    } else if(currentSpeedInKmh > 50 && currentSpeedInKmh <= 60){
      System.out.println("Jetzt wirds ein bisschen schnell!");
    } else {
    System.out.println("Ungültige Geschwindigkeit");
    }


    System.out.println("Ende");

  }
}
