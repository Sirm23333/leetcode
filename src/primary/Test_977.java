package primary;

import java.util.Arrays;

/**
 *977. 有序数组的平方
 *
 */
public class Test_977 {
    public int[] sortedSquares(int[] A) {
        for(int i = 0; i < A.length; i++){
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
