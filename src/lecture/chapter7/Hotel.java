package lecture.chapter7;

public class Hotel implements Bookable{

  private int rooms;
  private int bookedRooms;

  public Hotel(int rooms) {
    this.rooms = rooms;
    bookedRooms = 0;
  }

  @Override
  public boolean book(int slots) {
    if(slots > freeSlots()) {
      return false;
    }
    bookedRooms += slots;
    return true;
  }

  @Override
  public int freeSlots() {
    return rooms - bookedRooms;
  }

  public void clean(){
    System.out.println("Und ich putz, putz, putz... *sing*");
  }
}
