package lecture.chapter7;

import lecture.chapter8.InvalidSlotsToBookValueException;
import lecture.chapter8.NotEnoughFreeSlotsException;

public class TravelAgencyRun {

  public static void main(String[] args) {

    Airplane a380 = new Airplane(380);
    Hotel hilton = new Hotel(150);

    a380.flight();
    hilton.clean();

    try {
      a380.book(-50);
      System.out.println("Freue Plätze im Flugzeug: " + a380.freeSlots());

    } catch (NotEnoughFreeSlotsException exception) {
      System.out.println(exception.getMessage());

    }catch (InvalidSlotsToBookValueException exception) {
      System.out.println(exception.getMessage());

      System.out.println("Wir buchen den Betragswert:");

    }
    // Narrowing Cast
    Bookable thingToBook = a380;

    // Narrowing Cast
    Bookable[] bookableThingsForJourney = {a380, hilton, new Airplane(90), new Hotel(100), new Airplane(500), null};

    int neededSlotsForBooking = 99;
    for(Bookable currentThingToBook : bookableThingsForJourney) {

      // Polymorphie
      System.out.println("==== Etappenbuchung ===== ");
      try {
        System.out.println("Freie Plätze: " + currentThingToBook.freeSlots());

        try {
          currentThingToBook.book(neededSlotsForBooking);

          System.out.println("Erfolgreich gebucht " + currentThingToBook);
          System.out.println("Verbleidende Plätze: " + currentThingToBook.freeSlots());

        } catch (NotEnoughFreeSlotsException exception) {
          System.out.println(exception.getMessage());

          System.out.println("Wir versuchen gleich weniger zu buchen...");
          return;
        }catch(InvalidSlotsToBookValueException exception){
          System.out.println(exception.getMessage());

          System.out.println("Buche mehr Slots!!");
        }catch(Exception exception) {
          System.out.println("Irgend eine Ausnahme wurde geworfen :-( ");
        }finally{
          System.out.println("Finally läuft IMMER!");
        }

      }catch(NullPointerException exception) {
        System.out.println("Kein Buchungsobjekt gefunden");
      }

      if (currentThingToBook instanceof Airplane currentAirplane) {
        currentAirplane.flight();
      }

      if (currentThingToBook instanceof Comparable) {
        System.out.println(currentThingToBook + " könnten wir auch vergleichen --> weil Comparable implementiert wurde");
      }
    }


  }
}
