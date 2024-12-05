package excersises.chapter5.haus;

public class HausBauAG {

  public static void main(String[] args) {
    Haus myHaus = new HausBuilder().buildTueren(5).buildEtagen(3).buildFenster(5).build();
    Haus yourHaus = new HausBuilder().buildAdresse("Hauptstrasse", "5", "Mannheim", 67890).buildTueren(10).build();
  }
}
