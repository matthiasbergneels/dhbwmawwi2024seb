package lecture.chapter9;

import lecture.chapter5.Car;
import lecture.chapter5.CarBrand;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ListExamples {

  public static void main(String[] args) {

    List<String> nameList = new ArrayList<String>();

    nameList.add("Gabi");
    nameList.add("Daniel");
    nameList.add("Monika");
    nameList.add("Matthias");
    nameList.add("Zeus");
    //nameList.add(new Car("Black", "HSHSHSH", 123, CarBrand.MERCEDES));
    nameList.add("Friedolin");
    nameList.add("Friedolin");
    nameList.add("Friedolin");
    //nameList.add(10); // Auto-Boxing --> nameList.add(Integer.valueOf(10));
    //nameList.add(false);
    //nameList.add(.5e-10); // Auto-Boxing --> nameList.add(Double.valueOf(.5e-10));

    System.out.println("Anzahl Namenselemente:  " + nameList.size());

    System.out.println("Namelist Iteration mit For:");
    for(int i = 0; i < nameList.size(); i++){
      System.out.println(nameList.get(i));
    }

    nameList.remove(0);
    while(nameList.contains("Friedolin")){
      nameList.remove("Friedolin");
    }

    System.out.println("Anzahl Namenselemente:  " + nameList.size());

    System.out.println("Namelist Iteration mit For-Each:");
    for(String currentName : nameList){
      System.out.println(currentName);
      /*if(currentName.equals("Matthias")){
        nameList.add("Matthias");
      }

       */
    }

    System.out.println("Namelist Iteration mit Iterator:");
    Iterator<String> nameListIterator = nameList.iterator();
    while(nameListIterator.hasNext()){
      String currentName = nameListIterator.next();
      System.out.println(currentName);
      /* --> kann zu Inkonsistenzen führen
      if(currentName.equals("Matthias")){
        nameList.add("Matthias");
      }
       */

      if(currentName.equals("Matthias")){
        nameListIterator.remove();
      }
    }

    List<Integer> numberList = new Vector<Integer>();

    numberList.add(1);
    numberList.add(2);
    numberList.add(3);
    numberList.add(4);
    numberList.add(5);
    numberList.add(6);

    int sum = 0;
    // Wrapperklasse: Auto-Unboxing --> Integer Objekt wird automatisch zu einem int (einfacher Datentyp)
    for(int currentNumber : numberList){
      System.out.println(currentNumber);
      sum = sum + currentNumber;
    }



  }

}
