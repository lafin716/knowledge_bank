package com.lafin.knowledge.algorithm.programmers;

import java.util.*;

public class HIndex {

    public static void main(String[] args) {
        int[] input = new int[]{3,0,6,1,5};
        int answer = 0;

        Integer[] arr = Arrays.stream(input).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, Collections.reverseOrder());

        


    }
}