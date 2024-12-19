package lecture.chapter7;

import java.io.Serializable;

public class Airplane implements Bookable, Serializable, Comparable<Airplane> {

  private boolean[] bookedSeats;

  public Airplane(int seatNumber){
    bookedSeats = new boolean[seatNumber];
  }

  @Override
  public boolean book(int slots) {
    return false;
  }

  @Override
  public int freeSlots() {
    return 0;
  }


  public void flight(){
    System.out.println("und ich flieg, flieg, flieg... *sing*");
  }

  @Override
  public int compareTo(Airplane o) {
    return 0;
  }
}
