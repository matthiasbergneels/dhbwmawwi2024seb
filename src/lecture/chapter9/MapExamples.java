package lecture.chapter9;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExamples {

  public static void main(String[] args) {

    Map<Integer, String> cities = new HashMap<Integer, String>();

    cities.put(69844, "Weinheim");
    cities.put(69845, "Berlin");
    cities.put(69846, "London");

    System.out.println("Anzahl Städte: " + cities.size());
    System.out.println("PLZ 69844: " +  cities.get(69844));

    cities.put(69844, "Weindorf");

    System.out.println("PLZ 69844: " +  cities.get(69844));

    cities.remove(69846);

    System.out.println("Anzahl Städte: " + cities.size());

    Set<Integer> plz = cities.keySet();

    for(int currentPlz : plz){
      System.out.println("PLZ " + currentPlz + ": " +  cities.get(currentPlz));
    }

  }
}
