package lecture.chapter5;

public enum CarBrand {
  FIAT("$"),
  MERCEDES("$$$"),
  MITSUBISHI("$$"),
  OPEL("$$"),
  VW("$$");

  private final String priceTag;

  CarBrand(String priceTag){
    this.priceTag = priceTag;
  }

  public String getPriceTag(){
    return priceTag;
  }
}
