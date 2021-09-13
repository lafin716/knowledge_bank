package com.lafin.knowledge.algorithm.sort;

import java.util.List;

public class QuickSort implements Sort {

    @Override
    public List<Integer> sort(List<Integer> list) {
        if (list.size() < 2) return list;
        return quick(list, 0, list.size() - 1);
    }

    private List<Integer> quick(List<Integer> list, int start, int end) {
        if (start < end) return list;

        int pivot = start;
        int left = pivot + 1;
        int right = end;
        int temp = 0;

        while (left <= right) {
            while (left <= end && list.get(left) < list.get(pivot)) {
                left++;
            }

            while (right > start && list.get(right) >= list.get(pivot)) {
                right++;
            }

            if (left > right) {
                temp = list.get(right);
                list.set(right, list.get(pivot));
                list.set(pivot, temp);
            } else {
                temp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, temp);
            }
        }

        quick(list, start, right - 1);
        quick(list, right + 1, end);

        return list;
    }
    
    public static void main(String[] args) {
        List<Integer> data = SortData.getRandomDatas();
        System.out.println("원본 데이터 ==================================");
        SortData.printList(data);

        // 삽입 정렬
        System.out.println();
        System.out.println("퀵 정렬 데이터 ==================================");
        long start3 = System.nanoTime();
        InsertSort insertSort = new InsertSort();
        SortData.printList(insertSort.sort(data)); 
        long end3 = System.nanoTime();
        System.out.println("퀵 정렬 : " + ((end3 - start3) / 1000000000f) + " sec");
    }
}
