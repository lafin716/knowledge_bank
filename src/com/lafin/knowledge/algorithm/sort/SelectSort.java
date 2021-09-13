package com.lafin.knowledge.algorithm.sort;

import java.util.List;

public class SelectSort implements Sort {

    public List<Integer> sort(List<Integer> data) {
        
        for (int i = 0; i < data.size() - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < data.size(); j++) {
                if (data.get(j) < data.get(minIndex)) {
                    minIndex = j;
                }
            }

            int tmp = data.get(minIndex);
            data.set(minIndex, data.get(i));
            data.set(i, tmp);
        }

        return data;
    }
    
    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();

        List<Integer> data = SortData.getRandomDatas(100);

        long start = System.nanoTime();
        System.out.println("======= 정렬 전 ========");
        SortData.printList(data);
        List<Integer> sortedData = selectSort.sort(data);
        System.out.println("======= 정렬 후 ========");
        SortData.printList(sortedData);

        long end = System.nanoTime();
                
        System.out.println("수행시간: " + ((end - start) / 1000000000f) + " sec");
    }
}
