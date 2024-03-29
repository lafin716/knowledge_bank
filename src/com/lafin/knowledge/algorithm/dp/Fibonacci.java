package com.lafin.knowledge.algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치 수열 클래스
 * 동적 프로그래밍으로 구현한 피보나치 수열
 * 두 단계 이전의 수열의 합을 가진 수열이다
 * 점화식
 * f(n) = f(n-1) + f(n-2)
 * 
 * 만약 0, 1 인경우 그대로 리턴
 * 
 * @author lafin
 */
public class Fibonacci {

    // bottom-up 방식
    // 작은 문제부터 차근차근 구한다 
    public long bottomUp(long n) {
        if (n <= 1) return n;

        // 결과값
        long result = 0;

        // 첫번째 수열의 합 (n=1인 경우를 위해 0으로 설정)
        long first = 0;
        // 두번째 수열의 합
        long second = 1;

        // n 이전 수열의 합을 차례로 구해 올라가서 총합을 구한다
        for (int i = 0; i < n-1; i++) {
            result = first + second;
            first = second;
            second = result;
        }

        return result;
    }

    // top-down 방식
    // 재귀함수를 이용한다
    int[] memo;
    public long topDown(int n) {
        // 미리 배열을 생성 후에 아래 재귀함수에서 차례로 채워 넣는다
        int size = n + 1;
        memo = new int[size];
        return recursiveTopDown(n);
    }

    // top-down 재귀 함수
    public int recursiveTopDown(int n) {
        // 메모가 만들어 진 경우 값을 리턴
        if (memo[n] > 0) return memo[n];
        
        // 1 이하 인 경우 그대로 리턴
        if (n <= 1) return n;
        
        // 재귀를 통해 값을 리턴
        return recursiveTopDown(n - 1) + recursiveTopDown(n - 2);
    }

    
    public static void main(String[] args) throws NumberFormatException, IOException {
        Fibonacci fibonacci = new Fibonacci();
        // 속도를 위해 Scanner가 아닌 BufferedReader 사용
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(sc.readLine());

        // bottom-up 방식 
        System.out.println(fibonacci.bottomUp(n) % 1000000);
    }
}
