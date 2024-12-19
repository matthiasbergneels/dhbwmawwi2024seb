package lecture.chapter7;

public interface Bookable {

  boolean book(int slots);  // public abstract boolean book(int slots);
  int freeSlots();

}
