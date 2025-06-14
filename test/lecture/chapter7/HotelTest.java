package lecture.chapter7;

import lecture.chapter8.InvalidSlotsToBookValueException;
import lecture.chapter8.NotEnoughFreeSlotsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {


  @Test
  // BAD EXAMPLE
  void book() {

    Hotel hotelUnderTest = new Hotel(100);

    try {
      hotelUnderTest.book(101);
    } catch (NotEnoughFreeSlotsException e) {
      System.out.println(e.getMessage());
      Assertions.assertNotNull(e);
      return;
    } catch (InvalidSlotsToBookValueException e) {
      System.out.println(e.getMessage());
    }

    Assertions.assertTrue(false, "NotEnoughFreeSlotsException wurde nicht geworfen");
  }


  @Test
  void notEnoughFreeSlotsException(){
    Assertions.assertThrows(NotEnoughFreeSlotsException.class, new HotelTestExecutable());
  }

  @Test
  void notEnoughFreeSlotsExceptionLambdaImplementation(){
    Hotel hotelUnderTest = new Hotel(100);

    Assertions.assertThrows(NotEnoughFreeSlotsException.class, ()-> hotelUnderTest.book(101));
  }

  @Test
  void notEnoughFreeSlotsExceptionAnonymousClassImplementation(){
    Hotel hotelUnderTest = new Hotel(100);

    Assertions.assertThrows(NotEnoughFreeSlotsException.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        hotelUnderTest.book(101);
      }
    });
  }

}