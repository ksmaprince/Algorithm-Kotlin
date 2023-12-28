import java.util.Arrays;

public class BuilMaxHeapBottomUp {
    public static int comparison;

    private static void buildMaxHeapBottomUp(int[] A) {
        for (int i = (A.length) / 2; i >= 1; i--)
            downHeap(A, i);
    }

    private static void downHeap(int[] A, int i) {
        int j = i;
        int k = maxChildIndex(A, j);
        while (k != 0) {
            int temp = A[j];
            A[j] = A[k];
            A[k] = temp;
            j = k;
            k = maxChildIndex(A, j);
        }
        System.out.println(Arrays.toString(A));
    }

    private static int maxChildIndex(int[] A, int j) {
        int maxIndex = 0;
        int l = 2 * j;
        int r = 2 * j + 1;
        if (l < A.length) {
            int max = A[j];
            if (r < A.length) { // it has both left and right child
                comparison++;
                if (max < A[l]) {
                    max = A[l];
                    maxIndex = l;
                }
                if (max < A[r]) {
                    max = A[r];
                    maxIndex = r;
                }
            } else {  // it has only left child
                comparison++;
                if (A[l] > A[j]) {
                    if (max < A[l]) {
                        max = A[l];
                        maxIndex = l;
                    }
                }
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        //int[] A = {0, 56, 39, 14, 18, 75};
        //int[] A = {0, 7, 95, 1, 8, 25, 11, 100};
        //int [] A = {0, 7, 9, 2, 1, 11, 12, 4, 1, 50, 18};
        // int[] A = {0, 2, 9, 7, 6, 5, 8};
        int[] A = {0, 7, 2, 9, 1, 5, 4, 3 ,8, 6};
        int[] dataSet1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int[] dataSet2 = {0, 2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15};
        int[] dataSet3 = {0, 4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15};
        int[] dataSet4 = {0, 5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9};
        buildMaxHeapBottomUp(A);
        System.out.println("Number of comparison: " + comparison);
    }
}
