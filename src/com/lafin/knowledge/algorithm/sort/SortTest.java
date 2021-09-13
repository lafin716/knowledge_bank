package com.lafin.knowledge.algorithm.sort;

import java.util.List;

public class SortTest {

    // 정렬 팩토리
    public void doTest(List<Integer> data, Sort sortObject) {
        System.out.println("정렬 데이터 ==================================");
        long start1 = System.nanoTime();
        SortData.printList(sortObject.sort(data)); 
        long end1 = System.nanoTime();
        System.out.println("소요시간 : " + ((end1 - start1) / 1000000000f) + " sec");
    }
    
    public static void main(String[] args) {
        // 테스트 객체
        SortTest test = new SortTest();

        // 무작위 데이터
        List<Integer> data = SortData.getRandomDatas();
        System.out.println("원본 데이터 ==================================");
        SortData.printList(data);

        /**
         * 안정정렬
         * 값이 같을 때 서로 바꾸지 않는 정렬법
         * - 버블, 삽입, 병합
         */

        // 버블 정렬
        System.out.print("버블");
        test.doTest(data, new BubbleSort());

        // 삽입 정렬
        System.out.print("삽입");
        test.doTest(data, new InsertSort());


        /**
         * 불안정정렬
         * 값이 같을 때 서로 바꾸는 정렬법
         * - 선택, 퀵, 계수
         */

        // 선택 정렬
        System.out.print("선택");
        test.doTest(data, new SelectSort());

        // 퀵 정렬
        System.out.print("퀵");
        test.doTest(data, new QuickSort());
    }
}
