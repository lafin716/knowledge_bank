package com.lafin.knowledge_bank.algorithm;

import com.lafin.knowledge.ds.DynamicArray;

/**
 * 버블정렬 클래스
 * 선형구조의 자료구조에서 정렬할 때 사용하므로 DynamicArray를 사용하여 구현한다.
 * @author lafin
 *
 */
public class BubbleSort {
	
	// 정렬 메소드
	public static DynamicArray sort(DynamicArray origin) {
		DynamicArray sorted = origin;
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
		DynamicArray<Integer> data = new DynamicArray<Integer>();
		
		// 랜덤하게 데이터를 넣는다
		for(int i=0; i<100; i++) {
			
			// 1 ~ 100 까지 랜덤한 수 생성
			int random = (int) ((Math.random() * 100) + 1);			
			data.add(random);
		}
		
		System.out.println("정렬 전 배열 출력");
		data.print();
		
		// 버블정렬 실행
		data = BubbleSort.sort(data);
		System.out.println("정렬 후 배열 출력");
		data.print();
	}
}
