package lecture.chapter8;

public class InvalidSlotsToBookValueException extends Exception {

  public InvalidSlotsToBookValueException(int value){
    super("Invalid value for slots to Book - current value: " + value);
  }
}
