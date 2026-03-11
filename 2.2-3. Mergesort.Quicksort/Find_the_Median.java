import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Find_the_Median {

    public static int findMedian(int[] arr) {
        int target = arr.length / 2;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int pivotIndex = partition(arr, left, right);

            if (pivotIndex == target) {
                return arr[pivotIndex];
            } else if (pivotIndex > target) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }

        return arr[left];
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        int n = Integer.parseInt(line.trim());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findMedian(arr));
    }
}