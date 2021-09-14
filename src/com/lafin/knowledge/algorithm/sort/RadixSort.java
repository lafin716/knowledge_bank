package com.lafin.knowledge.algorithm.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RadixSort implements Sort {
    @Override
    public List<Integer> sort(List<Integer> list) {
        int max = getMax(list);

        // 자릿수 만큼 반복
        for (int exp = 1; max / exp > 0; exp *= 10) {
            list = countSort(list, exp);
        }
        
        return list;
    }

    // 자릿수만큼 카운팅 정렬
    private List<Integer> countSort(List<Integer> list, int exp) {
        int[] output = new int[list.size()];
        int[] count = new int[10];

        // count 값 count배열에 저장
        for (int i = 0; i < list.size(); i++) {
            int curr = list.get(i);

            count[(curr/exp) % 10]++;
        }

        // count 값이 포함시켜 count배열에 저장
        for (int i = 1; i < 10; i++) {
            count[i] += count[i-1];
        }

        // output 배열 빌드
        for (int i = list.size() - 1; i >= 0; i--) {
            output[count[list.get(i)/exp%10] - 1] = list.get(i);
            count[list.get(i)/exp%10]--;
        }

        // output 배열에 저장된 값을 data 배열에 저장
		for (int i = 0; i < list.size(); i++) {
			list.set(i, output[i]);
		}

        return list;
    }

    private int getMax(List<Integer> list) {
        if (list.size() == 0) return 0;

        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (max < list.get(i)) {
                max = list.get(i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Set<Integer> data = SortData.getRandomUniqueDatas(10);
        System.out.println("원본 데이터 ==================================");
        SortData.printList(data);

        // 기수 정렬
        System.out.println();
        System.out.println("기수 정렬 데이터 ==================================");
        long start3 = System.nanoTime();
        RadixSort heapSort = new RadixSort();
        SortData.printList(heapSort.sort(new ArrayList<>(data)));
        long end3 = System.nanoTime();
        System.out.println("기수 정렬 : " + ((end3 - start3) / 1000000000f) + " sec");
    }
}
