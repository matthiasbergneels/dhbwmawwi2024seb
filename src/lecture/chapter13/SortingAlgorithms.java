package lecture.chapter13;

public class SortingAlgorithms {

  public static void main(String[] args) {

    int[] toSort = {50, 70, 100, 80, 40, 30, 20, 10 ,60};
    System.out.println("Unsortiert: ");
    printArray(toSort);

    System.out.println("Bubble Sort V1 sortiert: ");
    int[] sorted = bubbleSort(toSort.clone());
    printArray(sorted);

    System.out.println("Bubble Sort V1 sortiert (reverse sorted - edge case): ");
    sorted = bubbleSort(new int[]{100, 90, 80, 70, 60, 50, 40, 30, 20, 10});
    printArray(sorted);

    System.out.println("Bubble Sort V2 sortiert: ");
    sorted = bubbleSortV2(toSort.clone());
    printArray(sorted);

  }

  public static int[] bubbleSort(int[] numbers){

    for(int i = 0; i < numbers.length-1; i++){
      for(int j = 0; j < numbers.length-1-i; j++){
        if(numbers[j] > numbers[j+1]){
          swap(numbers, j, j+1);
        }
      }
    }

    return numbers;
  }

  public static int[] bubbleSortV2(int[] numbers){

    boolean swapped = true;
    int sortedAreaSize = 0;

    while(swapped) {
      swapped = false;
      for (int j = 0; j < numbers.length - 1 - sortedAreaSize; j++) {
        if (numbers[j] > numbers[j + 1]) {
          swap(numbers, j, j + 1);
          swapped = true;
        }
      }
      sortedAreaSize++;
    }

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
