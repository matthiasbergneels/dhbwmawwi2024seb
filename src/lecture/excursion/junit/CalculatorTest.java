package lecture.excursion.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

  private Calculator testingCalculator;

  @BeforeEach
  void setup(){
    System.out.println("Setup - Vor jedem Test");
    testingCalculator = new Calculator();
  }

  @AfterEach
  void tearDown(){
    System.out.println("Tear Down - nach jedem Test");
    testingCalculator = null;
  }

  @Nested
  @DisplayName("Add Test Cases")
  class AddTestCases {

    @Test
    @Tag("unit")
    void add() {

      // Arrange

      // Act
      int erg = testingCalculator.add(1, 2);

      // Assert
      Assertions.assertEquals(3, erg);
    }
  }

  @Nested
  @DisplayName("Subtract Test Cases")
  class SubtractTestCases {

    @Test
    void subtract() {
      // Arrange


      // Act
      double erg = testingCalculator.subtract(1.0, 2.0);

      //Assert
      Assertions.assertEquals(-1.0, erg);
    }

    @Test
    void subtractWithIntValues() {
      // Arrange


      // Act
      double erg = testingCalculator.subtract(1, 2);

      //Assert
      Assertions.assertEquals(-1.0, erg);
    }

    @Test
    void subtractWithFloat() {
      // Arrange


      // Act
      double erg = testingCalculator.subtract(1f, .5f);

      //Assert
      Assertions.assertEquals(.5, erg);
    }
  }

  @Nested
  @DisplayName("Multiply Test Cases")
  class MultiplyTestCases {

    @ParameterizedTest(name = "multiply {0} with {1} exptected {2}")
    @CsvSource({
      "1.0, 2.0, 2.0",
      "2, 2, 4"})
    void multiplyCsv(double numberA, double numberB, double expected) {
      // Arrange

      // Act
      double result = testingCalculator.multiply(numberA, numberB);

      // Assert
      assertEquals(expected, result);
    }

  }

}