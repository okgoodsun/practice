import java.util.Arrays;

class InsertionSorter {

  public static int[] sort(int[] array) {
    for (int i = 0, j = 0; i < array.length; i++) {
      if (i < 1) continue; // first item, no need to compare

      // j's value will be the first item smaller than i's value
      for (j = i - 1; j >= 0; j--) {
        if (array[i] >= array[j]) break;
      }

      // Insert array[i] to array[j+1] and move all items [j+1, i-1] to next postion
      if (j < i - 1) {
        int temp = array[i];

        for (int k = i; k > j + 1; k--) {
          array[k] = array[k - 1];
        }
        
        array[j + 1] = temp;
      }
    }

    return array;
  }

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        sort(new int[] {3, 8, 6, 9, 2, 1, 5, 0})
      )
    );
  }

}
