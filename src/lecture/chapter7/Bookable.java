package lecture.chapter7;

public interface Bookable {

  boolean book(int slots);  // public abstract boolean book(int slots);
  int freeSlots();
  default boolean reserveSlots(int slots){
    return false;
  }
  default int reservedSlots(){
    return 0;
  }

}
