package lecture.chapter13;

public class SortingAlgorithms {

  public static void main(String[] args) {

    int[] toSort = {50, 70, 100, 80, 40, 30, 20, 10 ,60};
    System.out.println("Unsortiert: ");
    printArray(toSort);

    System.out.println("Bubble Sort V1 sortiert: ");
    int[] sorted = bubbleSort(toSort.clone());
    printArray(sorted);


  }

  public static int[] bubbleSort(int[] numbers){

    return numbers;
  }




  private static void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }

  public static void printArray(int[] numbers){
    for(int i = 0; i < numbers.length; i++){
      System.out.print(numbers[i] + ((i == numbers.length-1)?"" : ", "));
    }
    System.out.println();
  }
}
