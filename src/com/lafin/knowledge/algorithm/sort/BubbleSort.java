package com.lafin.knowledge.algorithm.sort;

import java.util.List;

/**
 * 버블정렬 클래스
 * 선형구조의 자료구조에서 정렬할 때 사용하므로 DynamicArray를 사용하여 구현한다.
 * @author lafin
 *
 */
public class BubbleSort implements Sort {
	
	// 정렬 메소드
	public List<Integer> sort(List<Integer> origin) {
		List<Integer> sorted = origin;
		boolean isReplaced = true;
		
		// 한번도 스왑이 일어나지 않을 때까지 반복
		while(isReplaced) {
			// 스왑 플래그를 false로 변경
			isReplaced = false;
			
			// 현재 숫자와 +1 위치의 숫자를 비교하므로 for문은 총 배열 사이즈의 -1 만큼 반복
			for(int i=0; i<sorted.size() - 1; i++) {
				int current = (int) sorted.get(i);
				int next = (int) sorted.get(i + 1);
				
				// 현재 값이 오른쪽보다 큰 경우 스왑
				if(current > next) {
					sorted.set(i, next);
					sorted.set(i+1, current);
					isReplaced = true;
				}
			}
		}
		
		return sorted;
	}
	
	// 테스트
	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();

		List<Integer> data = SortData.getRandomDatas(100);

        long start = System.nanoTime();
        System.out.println("======= 정렬 전 ========");
        SortData.printList(data);
        List<Integer> sortedData = bubbleSort.sort(data);
        System.out.println("======= 정렬 후 ========");
        SortData.printList(sortedData);
		long end = System.nanoTime();

        System.out.println("수행시간: " + ((end - start) / 1000000000f) + " sec");
	}
}
