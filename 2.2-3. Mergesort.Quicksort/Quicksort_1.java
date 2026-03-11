import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quicksort_1 {
    public static void partition(int[] ar) {
        int pivot = ar[0];
        List<Integer> left = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int num : ar) {
            if (num < pivot) {
                left.add(num);
            } else if (num > pivot) {
                right.add(num);
            } else {
                equal.add(num);
            }
        }

        int index = 0;
        for (int num : left) {
            ar[index++] = num;
        }
        for (int num : equal) {
            ar[index++] = num;
        }
        for (int num : right) {
            ar[index++] = num;
        }

        printArray(ar);
    }

    public static void printArray(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + (i == ar.length - 1 ? "" : " "));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = sc.nextInt();
            }
            partition(ar);
        }
        sc.close();
    }
}