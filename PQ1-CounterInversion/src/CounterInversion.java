import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * User: Shamika
 * Date: 10/28/15
 * Time: 11:12 AM
 */
public class CounterInversion {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input/IntegerArray.txt"));
        double[] x = new double[100000];
        int i = 0;
        while (scanner.hasNextInt()) {
            x[i] = scanner.nextInt();
            i++;
        }
        double y = mergeSort(x, 0, x.length - 1);

        System.out.println("Number of inversions =" + y);
    }

    public static double mergeSort(double[] a, int p, int r) {
        double inversionA = 0;
        double inversionB = 0;
        double counterInversion = 0;
        if (p < r) {
            int q = (p + r) / 2;
            inversionA = mergeSort(a, p, q);
            inversionB = mergeSort(a, q + 1, r);
            counterInversion = merge(a, p, q, r);
        }
        return inversionA + inversionB + counterInversion;
    }

    public static double merge(double[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        double crossInversion = 0;

        double[] L = new double[n1 + 1];
        double[] R = new double[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = a[i + p];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = a[q + j + 1];
        }
        L[n1] = Double.POSITIVE_INFINITY;
        R[n2] = Double.POSITIVE_INFINITY;

        int i = 0;
        int j = 0;

        for (int k = p; k < r + 1; k++) {
            if (L[i] < R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                crossInversion += (n1 - i);
                j++;

            }
        }
        return crossInversion;
    }
}
