package lecture.chapter7;

import lecture.chapter8.InvalidSlotsToBookValueException;
import lecture.chapter8.NotEnoughFreeSlotsException;

import java.io.Serializable;

public class Airplane implements PriorityBooking, Serializable, Comparable<Airplane> {

  private boolean[] bookedSeats;

  public Airplane(int seatNumber){
    bookedSeats = new boolean[seatNumber];
  }

  @Override
  public int freeSlots() {
    int freeSlots = 0;
    for(boolean bookedSeat : bookedSeats){
      if(!bookedSeat){
        freeSlots++;
      }
    }
    return freeSlots;
  }

  @Override
  public void book(int slots) throws NotEnoughFreeSlotsException, InvalidSlotsToBookValueException {
    if (slots <= 0) {
      throw new InvalidSlotsToBookValueException(slots);
    }

    if(slots > freeSlots()){
      throw new NotEnoughFreeSlotsException(freeSlots(), slots);
    }

    for(int i = 0; i < bookedSeats.length; i++){
      if(!bookedSeats[i]){
        bookedSeats[i] = true;
        slots--;
      }

      if(slots == 0){
        break;
      }
    }
  }

  @Override
  public boolean bookWithPriority(int slots) {
    return false;
  }


  public void flight(){
    System.out.println("und ich flieg, flieg, flieg... *sing*");
  }

  @Override
  public int compareTo(Airplane o) {
    return 0;
  }


}
