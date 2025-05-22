package lecture.chapter8;

public class NotEnoughFreeSlotsException extends Exception {

  private int freeSlots;

  public NotEnoughFreeSlotsException(int freeSlots, int slotsToBook) {
    super("Not enough free slots - tried to book " + slotsToBook + " remaining free slots " + freeSlots);
  }

  public int getFreeSlots() {
    return freeSlots;
  }

}
