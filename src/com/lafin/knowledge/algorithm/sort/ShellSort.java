package com.lafin.knowledge.algorithm.sort;

import java.util.List;

public class ShellSort implements Sort {
    
    @Override
    public List<Integer> sort(List<Integer> list) {

        for (int gap = list.size() / 2; gap > 0; gap = gap / 2) {
            if (gap % 2 == 0) {
                gap++; // 홀수로 만듬
            } 

            for (int i = 0; i < gap; i++) {
                list = shellSort(list, i, list.size() - 1, gap);
            }
        }

        return list;
    }

    // 부분 삽입 정렬
    private List<Integer> shellSort(List<Integer> list, int first, int last, int gap) {
        int j;

        for (int i = first + gap; i <= last; i = i+gap) {
            int key = list.get(i);

            for (j = i - gap; j >= first && list.get(j) > key; j = j - gap) {
                list.set(j + gap, list.get(j));
            }

            list.set(j + gap, key);
        }

        return list;
    }
    
    public static void main(String[] args) {
        List<Integer> data = SortData.getRandomDatas();
        System.out.println("원본 데이터 ==================================");
        SortData.printList(data);

        // 쉘 정렬
        System.out.println();
        System.out.println("쉘 정렬 데이터 ==================================");
        long start3 = System.nanoTime();
        ShellSort sort = new ShellSort();
        SortData.printList(sort.sort(data)); 
        long end3 = System.nanoTime();
        System.out.println("쉘 정렬 : " + ((end3 - start3) / 1000000000f) + " sec");
    }
}
