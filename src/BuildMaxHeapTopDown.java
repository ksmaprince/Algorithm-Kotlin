import java.util.Arrays;

public class BuildMaxHeapTopDown {
    static int comparison = 0;

    private static int buildMaxHeapTopDown(int A[]) {
        for (int i = 1; i < A.length; i++)
            upHeap(A, i);
        return comparison;
    }

    private static void upHeap(int A[], int i) {
        int j = i;
        while (j > 1) {
            comparison++;
            if (A[j / 2] < A[j]) {
                //Swapping
                int temp = A[j / 2];
                A[j / 2] = A[j];
                A[j] = temp;
            }
            j = j / 2;
        }
        //Print each step
        System.out.println(Arrays.toString(A));
    }


    public static void main(String[] args) {
       // int[] A = {0, 56, 39, 14, 18, 75};

        int[] A = {0, 7, 2, 9, 1, 5, 4, 3 ,8, 6};
        int[] dataSet1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int[] dataSet2 = {0, 2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15};
        int[] dataSet3 = {0, 4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15};
        int[] dataSet4 = {0, 5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9};
        int comparison = buildMaxHeapTopDown(dataSet1);
        System.out.println("Number of comparison: " + comparison);
    }
}
