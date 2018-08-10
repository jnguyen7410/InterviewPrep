public class Sort { 
  
  public static void mergeSort(int[] array, int l, int r) {
    if (array.length == 0) {
      return;
    }
    if (l < r) {
      int m = (l + r) / 2;
      mergeSort(array, l, m);
      mergeSort(array, m + 1, r);
      merge(array, l, m, r);
    }
  }
  
  public static void merge(int[] array, int l, int m, int r) {
    //instantiate an array for both sides
    int[] leftArr = new int[m - l + 1];
    for (int i = 0; i < leftArr.length; i++) {
      leftArr[i] = array[i+l];
    }
    
    int[] rightArr = new int[r - m];
    for (int i = 0; i < rightArr.length; i++) {
      rightArr[i] = array[i+m+1];
    }
    
    int indexLeft = 0;
    int indexRight = 0;
    int index = l;
    
    while(indexLeft < leftArr.length && indexRight < rightArr.length) {
      if (leftArr[indexLeft] < rightArr[indexRight]) {
        array[index] = leftArr[indexLeft];
        indexLeft++;
      } else if (rightArr[indexRight] <= leftArr[indexLeft]) {
        array[index] = rightArr[indexRight];
        indexRight++;
      }
      index++;
    }
    
    while(indexLeft < leftArr.length) {
      array[index] = leftArr[indexLeft];
      indexLeft++;
      index++;
    }
    
    while(indexRight < rightArr.length) {
      array[index] = rightArr[indexRight];
      indexRight++;
      index++;
    } 
  }
  
  public static boolean inOrder(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      if (array[i] > array[i+1]) {
        return false;
      }
    }
    return true;
  }
  
  public static String printArray(int[] array) {
    String result = "";
    for (int i = 0; i < array.length; i++) {
      result += array[i] + " ";
    }
    return result;
  }

  public static void quickSort(int[] array) {
    
  }
  
  public static void main(String[] args) {
    int[] array = { 1, 8, 6, 5, 8, 10, 28, 18394, 383, 123, 81, 28, 56, 94};
    System.out.println("Before Sorting - In Order: " + inOrder(array));
    System.out.println("array " + printArray(array));
    mergeSort(array, 0, array.length - 1);
    System.out.println("After Sorting - In Order: " + inOrder(array));
    System.out.println("array " + printArray(array));
  }
}