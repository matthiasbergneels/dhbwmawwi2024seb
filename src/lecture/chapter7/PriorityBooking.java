package lecture.chapter7;

public interface PriorityBooking extends Bookable {
  boolean bookWithPriority(int slots);
  default int availableSlots(){
    return freeSlots() + reservedSlots();
  }
}
