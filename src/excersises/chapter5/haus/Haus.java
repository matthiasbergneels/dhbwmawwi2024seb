package excersises.chapter5.haus;

public class Haus {

  public enum BUILD_TYPE{
    FENSTER,
    TUEREN,
    ETAGEN
  }

  public static final int DEFAULT_TUEREN_ANZAHL = 2;
  public static final int DEFAULT_FENSTER_ANZAHL = 6;
  public static final int DEFAULT_ETAGEN_ANZAHL = 2;
  public static final String DEFAULT_STRASSE = "Hauptstraße";
  public static final double DEFAULT_FLAECHE = 80.0;
  public static final String DEFAULT_HAUSNUMMER = "1A";
  public static final int DEFAULT_PLZ = 69190;
  public static final String DEFAULT_ORT = "Walldorf";


  private int tueren;
  private int fenster;
  private int etagen;
  private double flaeche;
  private String strasse;
  private String hausnummer;
  private int plz;
  private String ort;
  private boolean flachdach;

  private static int hauszaehler;

  // Konstruktoren
  public Haus(int tueren, int fenster, int etagen, double flaeche, String straße, String hausnummer, int plz, String ort, boolean flachDach) {
    this.setTueren(tueren);
    this.setFenster(fenster);
    this.setEtagen(etagen);
    this.setFlaeche(flaeche);
    this.setStraße(straße);
    this.setOrt(ort);
    this.setPlz(plz);
    this.setHausnummer(hausnummer);
    this.setFlachDach(flachDach);

    hauszaehler++;
  }

  public Haus() {
    this(DEFAULT_TUEREN_ANZAHL, DEFAULT_FENSTER_ANZAHL, DEFAULT_ETAGEN_ANZAHL, DEFAULT_FLAECHE, DEFAULT_STRASSE, DEFAULT_HAUSNUMMER, DEFAULT_PLZ, DEFAULT_ORT, false);
  }

  // Überladene Konstruktoren nach Aufgabe
  // Türen Konstruktor
  public Haus(int tueren){
    this(tueren, DEFAULT_FENSTER_ANZAHL, DEFAULT_ETAGEN_ANZAHL, DEFAULT_FLAECHE, DEFAULT_STRASSE, DEFAULT_HAUSNUMMER, DEFAULT_PLZ, DEFAULT_ORT, false);
  }

  // Fenster Konstruktor mit anderem Datentype → nicht so geil
  public Haus(byte fenster){
    this(DEFAULT_TUEREN_ANZAHL, fenster, DEFAULT_ETAGEN_ANZAHL, DEFAULT_FLAECHE, DEFAULT_STRASSE, DEFAULT_HAUSNUMMER, DEFAULT_PLZ, DEFAULT_ORT, false);
  }

  // Konstruktor mit BUILD_TYPE → auch nicht so geil
  public Haus(BUILD_TYPE toBuild, int value){
    this(DEFAULT_TUEREN_ANZAHL, DEFAULT_FENSTER_ANZAHL, DEFAULT_ETAGEN_ANZAHL, DEFAULT_FLAECHE, DEFAULT_STRASSE, DEFAULT_HAUSNUMMER, DEFAULT_PLZ, DEFAULT_ORT, false);

    if(toBuild == BUILD_TYPE.FENSTER){
      this.setFenster(value);
    } else if(toBuild == BUILD_TYPE.TUEREN){
      this.setTueren(value);
    } else if(toBuild == BUILD_TYPE.ETAGEN){
      this.setEtagen(value);
    }
  }

  // Lösungsansatz Factory Methods
  // → Nicht ganz so schlecht
  public static Haus baueHausMitTueren(int tueren){
    return new Haus(tueren, DEFAULT_FENSTER_ANZAHL, DEFAULT_ETAGEN_ANZAHL, DEFAULT_FLAECHE, DEFAULT_STRASSE, DEFAULT_HAUSNUMMER, DEFAULT_PLZ, DEFAULT_ORT, false);
  }

  public static Haus baueHausMitFenstern(int fenster){
    return new Haus(DEFAULT_TUEREN_ANZAHL, fenster, DEFAULT_ETAGEN_ANZAHL, DEFAULT_FLAECHE, DEFAULT_STRASSE, DEFAULT_HAUSNUMMER, DEFAULT_PLZ, DEFAULT_ORT, false);
  }

  public static Haus baueHausMitTuerenUndMitFenstern(int tueren, int fenster){
    return new Haus(tueren, fenster, DEFAULT_ETAGEN_ANZAHL, DEFAULT_FLAECHE, DEFAULT_STRASSE, DEFAULT_HAUSNUMMER, DEFAULT_PLZ, DEFAULT_ORT, false);
  }

  // Getter & Setter
  public int getTueren() {
    return tueren;
  }

  public void setTueren(int tueren) {
    if(tueren > 0) {
      this.tueren = tueren;
    } else {
      this.tueren = DEFAULT_TUEREN_ANZAHL;
    }

  }

  public int getFenster() {
    return fenster;
  }

  public void setFenster(int fenster) {
    if(fenster > 0) {
      this.fenster = fenster;
    } else {
      this.fenster = DEFAULT_FENSTER_ANZAHL;
    }
  }

  public int getEtagen() {
    return etagen;
  }

  public void setEtagen(int etagen) {
    if(etagen > 0) {
      this.etagen = etagen;
    } else {
      this.etagen = DEFAULT_ETAGEN_ANZAHL;
    }
  }

  public double getFlaeche() {
    return flaeche;
  }

  public void setFlaeche(double flaeche) {
    if(flaeche > 0) {
      this.flaeche = flaeche;
    } else {
      this.flaeche = DEFAULT_FLAECHE;
    }
  }

  public String getStraße() {
    return strasse;
  }

  public void setStraße(String strasse) {
    if(strasse != null && strasse.isBlank()){
      this.strasse = strasse;
    } else {
      this.strasse = DEFAULT_STRASSE;
    }
  }

  public String getHausnummer() {
    return hausnummer;
  }

  public void setHausnummer(String hausnummer) {
    if(hausnummer != null && hausnummer.isBlank()){
      this.hausnummer = hausnummer;
    } else {
      this.hausnummer = DEFAULT_HAUSNUMMER;
    }
  }

  public int getPlz() {
    return plz;
  }

  public void setPlz(int plz) {
    if(plz > 0 && plz < 10_000) {
      this.plz = plz;
    } else {
      this.plz = DEFAULT_PLZ;
    }
  }

  public String getOrt() {
    return ort;
  }

  public void setOrt(String ort) {
    if(ort != null && ort.isBlank()){
      this.ort = ort;
    } else {
      this.ort = DEFAULT_ORT;
    }
  }

  public boolean isFlachDach() {
    return flachdach;
  }

  public void setFlachDach(boolean flachdach) {
    this.flachdach = flachdach;
  }

  public static int getHauszaehler() {
    return hauszaehler;
  }
}
