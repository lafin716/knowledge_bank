package com.lafin.knowledge.algorithm.sort;

import java.util.List;

public class InsertSort implements Sort {

    @Override
    public List<Integer> sort(List<Integer> list) {

        for (int i = 1; i < list.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                // 왼쪽 수 보다 작은경우 스왑
                if (list.get(j) > list.get(j + 1)) {
                    int tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                } else {
                    
                }
            }
        }

        return list;
    }
    
    public static void main(String[] args) {
        List<Integer> data = SortData.getRandomDatas();
        System.out.println("원본 데이터 ==================================");
        SortData.printList(data);

        // 삽입 정렬
        System.out.println();
        System.out.println("삽입 정렬 데이터 ==================================");
        long start3 = System.nanoTime();
        InsertSort insertSort = new InsertSort();
        SortData.printList(insertSort.sort(data)); 
        long end3 = System.nanoTime();
        System.out.println("삽입 정렬 : " + ((end3 - start3) / 1000000000f) + " sec");
    }
}
