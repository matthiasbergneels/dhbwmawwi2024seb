package lecture.chapter7;

public class TravelAgencyRun {

  public static void main(String[] args) {

    Airplane a380 = new Airplane(380);
    Hotel hilton = new Hotel(150);

    a380.flight();
    hilton.clean();

    a380.book(150);
    System.out.println("Freue Plätze im Flugzeug: " + a380.freeSlots());

    // Narrowing Cast
    Bookable thingToBook = a380;

    // Narrowing Cast
    Bookable[] bookableThingsForJourney = {a380, hilton, new Airplane(90), new Hotel(100), new Airplane(500)};

    int neededSlotsForBooking = 99;
    for(Bookable currentThingToBook : bookableThingsForJourney) {
      // Polymorphie
      System.out.println("==== Etappenbuchung ===== ");
      System.out.println("Freie Plätze: " + currentThingToBook.freeSlots());
      boolean successfulBooking = currentThingToBook.book(neededSlotsForBooking);
      if(successfulBooking) {
        System.out.println("Erfolgreich gebucht " + currentThingToBook);
        System.out.println("Verbleidende Plätze: " + currentThingToBook.freeSlots());
      }else {
        System.out.println("Buchung Fehlgeschlagen " + currentThingToBook);
        if(currentThingToBook instanceof PriorityBooking currentPrioBooking) {
          successfulBooking = currentPrioBooking.bookWithPriority(neededSlotsForBooking);
        }
      }

      if(currentThingToBook instanceof Airplane currentAirplane) {
        currentAirplane.flight();
      }

      if(currentThingToBook instanceof Comparable) {
        System.out.println(currentThingToBook + " könnten wir auch vergleichen --> weil Comparable implementiert wurde");
      }
    }


  }
}
