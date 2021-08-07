package com.lafin.knowledge.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 막대기 자르기 문제
 * 동적 프로그래밍 문제
 * 주어진 막대기의 길이를 적절하게 잘라 제일 높은 가격을 구한다
 */
public class CutStick {

    // 막대기는 0 ~ 10 까지 주어진다.
    int[] prices = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

    // 막대기 자르기
    public int cut(int stickLength) {

        List<Integer> storedStickPrice = new ArrayList<>();
        storedStickPrice.add(0, 0);

        // 막대기 길이 만큼 반복
        for (int i = 1; i <= stickLength; i++) {
            // 초기 max 값
            int max = -1;

            // 현재 막대기 길이만큼 반복
            for (int j = 1; j <= i; j++) {
                // 저장된 막대기 값
                max = Math.max(max, prices[j] + storedStickPrice.get(i - j));
            }

            // 막대기 값 저장
            storedStickPrice.add(i, max);
        }

        return storedStickPrice.get(stickLength);
    }

    public static void main(String[] args) {
        CutStick cutStick = new CutStick();
        System.out.println(cutStick.cut(2));
        System.out.println(cutStick.cut(3));
        System.out.println(cutStick.cut(4));
        System.out.println(cutStick.cut(7));
    }
    
}
