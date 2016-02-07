import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * User: Shamika
 * Date: 11/1/15
 * Time: 11:40 AM
 */
public class QuickSort1 {
    //variable to track number of comparisons
    static double comparisons = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input/QuickSort.txt"));
        int[] x = new int[10000];
        int i = 0;
        while (scanner.hasNextInt()) {
            x[i] = scanner.nextInt();
            i++;
        }
        quickSort(x, 0, x.length - 1);

        System.out.println("comparisons=" + comparisons);
    }

    /**
     * Quick Sort Algorithm
     * @param array
     * @param l - lowest index
     * @param h - upper index
     */
    public static void quickSort(int[] array, int l, int h) {
        if (l < h) {
            //increment number of comparisons in each recursive call
            comparisons += h - l;
            int p = partition(array, l, h);
            quickSort(array, l, p - 1);
            quickSort(array, p + 1, h);
        }
    }

    /**
     * Get the partition index of the array according to pivot
     * @param array
     * @param l
     * @param h
     * @return
     */
    public static int partition(int[] array, int l, int h) {
        //Take the 1st element as pivot
        int pivot = array[l];
        int i = l + 1;
        for (int j = l + 1; j <= h; j++) {
            if (array[j] <= pivot) {

                swap(array, i, j);
                i++;
            }
        }
        swap(array, l, i - 1);
        return i - 1;
    }

    /**
     * Utility method to swap two elements in an array
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
