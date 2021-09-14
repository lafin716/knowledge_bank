package com.lafin.knowledge.algorithm.sort;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SortTest {

    private NumberFormat format = NumberFormat.getInstance();

    // 정렬 팩토리
    public void doTest(Set<Integer> data, Sort sortObject) {
        // System.out.println("정렬 데이터 ==================================");
        long start1 = System.nanoTime();
        // SortData.printList(); 
        sortObject.sort(new ArrayList<>(data));
        long end1 = System.nanoTime();
        
        format.setGroupingUsed(false);
        System.out.println(" 정렬 소요시간 : " + format.format((end1 - start1) / 1000000000.0) + " sec") ;
    }

    // 정렬 팩토리
    public void doTest(List<Integer> data, Sort sortObject) {
        // System.out.println("정렬 데이터 ==================================");
        long start1 = System.nanoTime();
        sortObject.sort(data);
        // SortData.printList(sortObject.sort(data)); 
        long end1 = System.nanoTime();

        format.setGroupingUsed(false);
        System.out.println(" 정렬 소요시간 : " + format.format((end1 - start1) / 1000000000.0) + " sec") ;
    }
    
    public static void main(String[] args) {
        // 테스트 객체
        SortTest test = new SortTest();

        // 무작위 데이터
        int dataCount = 120000;
        Set<Integer> data = SortData.getRandomUniqueDatas(dataCount);
        System.out.println("## " + dataCount + " 개 랜덤 데이터 생성 ##");

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

        // 병합 정렬
        System.out.print("병합");
        test.doTest(data, new MergeSort());

        // 힙 정렬
        System.out.print("힙");
        test.doTest(data, new HeapSort());

        // 쉘 정렬
        System.out.print("쉘");
        test.doTest(data, new ShellSort());

        // 기수 정렬
        System.out.print("기수");
        test.doTest(data, new RadixSort());


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
