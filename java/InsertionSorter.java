import java.util.Arrays;

class InsertionSorter {

  public static int[] sort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      if (i < 1) continue; // first item, no need to compare

      for (int j = i; j > 0; j--) {
        if (array[j] < array[j - 1]) {
          int x = array[j];
          array[j] = array[j - 1];
          array[j - 1] = x;
        } else {
          break;
        }
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
