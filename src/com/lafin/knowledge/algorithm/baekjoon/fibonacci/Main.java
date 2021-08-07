package com.lafin.knowledge.algorithm.baekjoon.fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Integer[][] table = new Integer[41][2];
    
    static Integer[] fibonacci(int n) {
        
        if (table[n][0] == null || table[n][1] == null) {
            table[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            table[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }

        return table[n];
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Main main = new Main();

        // 속도를 위해 Scanner가 아닌 BufferedReader 사용
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        table[0][0] = 1;
        table[0][1] = 0;
        table[1][0] = 0;
        table[1][1] = 1;

        int testCaseCount = Integer.parseInt(sc.readLine());

        while(testCaseCount > 0) {
            int n = Integer.parseInt(sc.readLine());
            Integer[] result = fibonacci(n);

            System.out.println(result[0] + " " + result[1]);

            testCaseCount--;
        }
    }
}
