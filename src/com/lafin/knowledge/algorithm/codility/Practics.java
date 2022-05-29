package com.lafin.knowledge.algorithm.codility;

import java.util.Arrays;

public class Practics {

    public int solution(int[] A) {
        Arrays.sort(A);

        int firstNumber = A[0];
        int lastNumber = A[A.length - 1];

        if (firstNumber > 1 || lastNumber <= 0) {
            return 1;
        }

        int middleIndex = A.length / 2;

        for (int i = middleIndex; i >= 1; i--) {
            int difference = A[i] - A[i - 1];
            if (difference > 1) {
                return A[i] - 1;
            }
        }

        for (int i = middleIndex; i < A.length - 1; i++) {
            int difference = A[i + 1] - A[i];
            if (difference > 1) {
                return A[i] + 1;
            }
        }

        return lastNumber + 1;
    }

    public static void main(String[] args) {
        Practics pc = new Practics();

        int result = pc.solution(new int[]{1,3,6,4,1,2});
        System.out.println("result : " + result);

    }
}
