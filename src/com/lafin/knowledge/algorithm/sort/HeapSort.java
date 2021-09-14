package com.lafin.knowledge.algorithm.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 자바에서는 우선순위큐가 힙을 사용하므로 우선순위큐로 힙정렬 수행
 */
public class HeapSort implements Sort {
    
    @Override
    public List<Integer> sort(List<Integer> list) {
        Queue queue = new PriorityQueue<>(list);
        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        Set<Integer> data = SortData.getRandomUniqueDatas(10);
        System.out.println("원본 데이터 ==================================");
        SortData.printList(data);

        // 힙 정렬
        System.out.println();
        System.out.println("힙 정렬 데이터 ==================================");
        long start3 = System.nanoTime();
        HeapSort heapSort = new HeapSort();
        SortData.printList(heapSort.sort(new ArrayList<>(data)));
        long end3 = System.nanoTime();
        System.out.println("힙 정렬 : " + ((end3 - start3) / 1000000000f) + " sec");
    }
}
