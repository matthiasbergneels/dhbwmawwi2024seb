package lecture.chapter4;

public class SwitchCaseExamples {

  public static void main(String[] args) {

    int grade = 3;

    switch(grade){
      case 1:
        System.out.println("Sehr gut");
        break;
      case 2:
        System.out.println("Gut");
        break;
      case 3:
        System.out.println("Befriedigend");
        break;
      case 4:
        System.out.println("Ausreichend");
        break;
      case 5:
        System.out.println("Ungenügend");
        break;
      default:
        System.out.println("Keine gültige Note");
    }

    switch(grade){
      case 1, 2, 3, 4:
        System.out.println("Bestanden");
        break;
      case 5:
        System.out.println("Nicht Bestanden");
        break;
      default:
        System.out.println("Keine gültige Note");
    }

    switch(grade){
      case 1 -> System.out.println("Sehr gut");
      case 2 -> System.out.println("Gut");
      case 3 -> System.out.println("Befriedigend");
      case 4 -> System.out.println("Ausreichend");
      case 5 -> System.out.println("Ungenügend");
      default -> System.out.println("Ungültige Note");
    }

    String gradeEvaluation = switch(grade){
      case 1 -> "Sehr gut";
      case 2 -> "Gut";
      case 3 -> "Befriedigend";
      case 4 -> "Ausreichend";
      case 5 -> "Ungenügend";
      default -> "Ungültige Note";
    };

    System.out.println(gradeEvaluation);

    gradeEvaluation = switch(grade){
      case 1, 2, 3, 4 -> "Bestanden";
      case 5 -> "Nicht bestanden";
      default -> "Ungültige Note";
    };
    System.out.println(gradeEvaluation);

    String weekday = "Monday";
    int numLetters = switch (weekday) {
      case "MONDAY", "FRIDAY", "SUNDAY" -> 6;
      case "TUESDAY" -> 7;
      default -> {
        int result = weekday.length();
        yield result;
      }
    };

  }
}
