package lecture.chapter7;

import lecture.chapter8.NotEnoughFreeSlotsException;

public interface Bookable {

  void book(int slots) throws NotEnoughFreeSlotsException;  // public abstract boolean book(int slots);
  int freeSlots();
  default boolean reserveSlots(int slots){
    return false;
  }
  default int reservedSlots(){
    return 0;
  }

}
