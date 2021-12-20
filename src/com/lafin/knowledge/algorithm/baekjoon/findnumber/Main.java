package com.lafin.knowledge.algorithm.baekjoon.findnumber;

import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> A = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        String nStr = br.readLine();
        String[] nStrs = nStr.split(" ");
        for (int i = 0; i < nStrs.length; i++) {
            int a = Integer.parseInt(nStrs[i]);
            A.put(a, 1);
        }

        int M = Integer.parseInt(br.readLine());
        String mStr = br.readLine();
        String[] mStrs = mStr.split(" ");
        for (int i = 0; i < mStrs.length; i++) {
            int m = Integer.parseInt(mStrs[i]);
            System.out.println(A.getOrDefault(m, 0));
        }
    }
}
