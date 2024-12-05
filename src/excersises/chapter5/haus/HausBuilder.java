package excersises.chapter5.haus;

public class HausBuilder {

  private Haus underconstructionHouse;

  public HausBuilder() {
    this.underconstructionHouse = new Haus();
  }

  public HausBuilder buildTueren(int tueren){
    underconstructionHouse.setTueren(tueren);
    return this;
  }

  public HausBuilder buildFenster(int fenster){
    underconstructionHouse.setFenster(fenster);
    return this;
  }

  public HausBuilder buildEtagen(int etagen){
    underconstructionHouse.setEtagen(etagen);
    return this;
  }

  public HausBuilder buildAdresse(String strasse, String hausnummer, String ort, int plz){
    underconstructionHouse.setStraße(strasse);
    underconstructionHouse.setHausnummer(hausnummer);
    underconstructionHouse.setOrt(ort);
    underconstructionHouse.setPlz(plz);

    return this;
  }

  public Haus build(){
    return underconstructionHouse;
  }

}
