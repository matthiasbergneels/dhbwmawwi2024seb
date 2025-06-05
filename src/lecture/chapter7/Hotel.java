package lecture.chapter7;

import lecture.chapter8.InvalidSlotsToBookValueException;
import lecture.chapter8.NotEnoughFreeSlotsException;

public class Hotel implements Bookable{

  private int rooms;
  private int bookedRooms;

  public Hotel(int rooms) {
    this.rooms = rooms;
    bookedRooms = 0;
  }

  @Override
  public void book(int slots) throws NotEnoughFreeSlotsException, InvalidSlotsToBookValueException {
    if (slots <= 0) {
      throw new InvalidSlotsToBookValueException(slots);
    }

    if(slots > freeSlots()) {
      //return false;
      NotEnoughFreeSlotsException notEnoughFreeSlotsException = new NotEnoughFreeSlotsException(freeSlots(), slots);
      throw notEnoughFreeSlotsException;
    }
    bookedRooms += slots;
  }

  @Override
  public int freeSlots() {
    return rooms - bookedRooms;
  }

  public void clean(){
    System.out.println("Und ich putz, putz, putz... *sing*");
  }
}
