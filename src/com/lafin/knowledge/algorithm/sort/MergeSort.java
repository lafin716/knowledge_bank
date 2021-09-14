package com.lafin.knowledge.algorithm.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MergeSort implements Sort {

    @Override
    public List<Integer> sort(List<Integer> list) {
        if (list.size() < 2) return list;
        divide(list, 0, list.size() - 1);

        return list;
    }

    private void divide(List<Integer> list, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            divide(list, left, middle);
            divide(list, middle + 1, right);
            merge(list, left, middle, right);
        }
    }

    private void merge(List<Integer> list, int left, int middle, int right) {
        int[] merged = new int[list.size()];
        int i = left;
        int j = middle + 1;
        int k = left;

        while (i <= middle || j <= right) {
            if (j > right || (i <= middle && list.get(i) < list.get(j))) {
                merged[k++] = list.get(i++);
            } else {
                merged[k++] = list.get(j++);
            }
        }

        for (int n = left; n <= right; n++) {
            list.set(n, merged[n]);
        }
    }

    public static void main(String[] args) {
        Set<Integer> data = SortData.getRandomUniqueDatas(10);
        System.out.println("원본 데이터 ==================================");
        SortData.printList(data);

        // 머지 정렬
        System.out.println();
        System.out.println("병합 정렬 데이터 ==================================");
        long start3 = System.nanoTime();
        MergeSort insertSort = new MergeSort();
        SortData.printList(insertSort.sort(new ArrayList<>(data)));
        long end3 = System.nanoTime();
        System.out.println("병합 정렬 : " + ((end3 - start3) / 1000000000f) + " sec");
    }
}
