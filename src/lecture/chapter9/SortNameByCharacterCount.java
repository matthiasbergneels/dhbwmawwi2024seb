package lecture.chapter9;

import java.util.Comparator;

public class SortNameByCharacterCount implements Comparator<String> {

  public int compare(String s1, String s2) {
    return s1.length() - s2.length();
  }
}
