package com.lafin.knowledge.ds;

/**
 * 배열 리스트 클래스
 * 기본자료구조인 배열을 구현한다
 * 제네릭클래스로 구현하여 타입 확장성을 갖춤
 * @author lafin
 *
 */
public class DynamicArray<T> {
	
	// 실제 데이터가 들어있는 배열 사이즈 설정
	private Integer size = 0;
	
	// 배열 증가값 설정
	private Integer increaseSize = 10;
	
	// 배열의 인덱스 번호
	private Integer index = 0;
	
	// 제네릭 타입 배열
	private Object[] dataList = null;
	
	// 기본 생성자
	public DynamicArray(){
		// 초기 배열을 선언
		dataList = new Object[increaseSize];
	}
	
	// 증가값 설정 생성자
	public DynamicArray(int increase){
		
		// 증가값을 직접 설정하는데에 따라 클래스의 시간복잡도와 공간복잡도 효율이 달라진다.
		increaseSize = increase;
		
		// 초기 배열을 선언
		dataList = new Object[increaseSize];
	}
	
	// 자동으로 마지막 위치에 객체 삽입
	public void add(T data) {
		
		// 인덱스가 현재 배열의 크기와 같으면 오류가 나므로 배열을 늘려준다.
		if(index == dataList.length) {
			grow();
		}
		
		dataList[index] = data;
		index++;
		size++;
	}
	
	// 인덱스를 지정하여 객체 치환
	// 인덱스 번호가 실제 데이터 최대인덱스 보다 큰 값이면 마지막에 추가하는거로 처리
	public void set(int index, T data) {
		
		// 인덱스가 사이즈보다 작을때 해당 인덱스에 있는 값을 치환
		if(index < size) {
			dataList[index] = data;
		}else {
			add(data);
		}
	}
	
	// 데이터 가져오기
	public T get(int index) {
		// 실제 데이터가 없는 인덱스를 호출 시 null값 리턴
		if(index >= size) return null;
		return (T) dataList[index];
	}
	
	// 데이터 지우기
	public void remove(int index) {
		
		// 인덱스는 실제크기보다 작아야함
		if(index >= size) return;
		
		// 지우려는 인덱스 번호에서 실제크기보다 1 작은 만큼 반복
		// 데이터를 앞으로 당기는 작업이므로 실제데이터의 끝이 아닌 인덱스가 1이 작은 데이터까지만 반복해야함
		for(int i=index; i<size - 1; i++) {
			dataList[i] = dataList[i+1];
		}
		
		// 사이즈와 인덱스번호 1 줄이기
		index--;
		size--;
	}
	
	// 사이즈 가져오기
	public int size() {
		return size;
	}
	
	// 배열크기 늘리기
	private void grow() {
		
		// 배열 사이즈를 증가값만큼 증가한 새 배열 생성
		Object[] newDataList = new Object[dataList.length + increaseSize];
		
		// 기존데이터를 새배열에 세팅
		for(int i=0; i<dataList.length; i++) {
			newDataList[i] = dataList[i];
		}
		
		// 새 배열을 데이터로 지정
		dataList = newDataList;
	}
	
	// 배열 출력
	public void print() {
		
		System.out.print("[");
		for(int i=0; i<size; i++) {
			System.out.print(dataList[i].toString()+",");
		}
		System.out.println("]");
	}
	
	
	// 테스트
	public static void main(String[] ar) {
		
		DynamicArray<Integer> list = new DynamicArray<Integer>();
		
		for(int i=1; i<100; i++) {
			list.add(i);
		}
		
		list.remove(0);
		list.remove(4);
		list.remove(20);
		
		list.set(20, 999);
		
		list.print();
		
		System.out.println("get(20) : " + list.get(20));
		System.out.println("size : "+list.size());
		
		
		
	}
}
