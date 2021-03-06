package com.lafin.knowledge.ds;

public class Queue<E> {
	
	// 큐의 첫번째 인덱스
	private int firstIndex;
	
	// 큐의 마지막 인덱스
	private int lastIndex;
	
	// 큐 데이터 배열
	private Object[] data;
	
	// 실제 배열데이터 크기
	private int size;
	
	// 현재 배열크기
	private int arraySize;
	
	// 배열 증가값
	private int defaultSize;
	
	// 생성자
	public Queue() {
		init();
	}
	
	// 배열 증가값 설정 생성자
	public Queue(int size) {
		init(size);
	}
	
	// 초기화
	public void init() {
		this.defaultSize = 10;
		this.arraySize = defaultSize;
		this.data = new Object[defaultSize];
		this.size = 0;
		this.firstIndex = 0;
		this.lastIndex = 0;
	}
	
	// 초기화
	public void init(int defaultSize) {
		this.defaultSize = defaultSize;
		this.arraySize = defaultSize;
		this.data = new Object[defaultSize];
		this.size = 0;
		this.firstIndex = 0;
		this.lastIndex = 0;
	}
	
	// 데이터 빼기
	public E pop() {
		if(size == 0) return null;
		E popData = (E) this.data[firstIndex];
		this.firstIndex++;
		this.size--;
		
		return popData;
	}
	
	// 데이터 넣기
	public void push(E data) {
		
		// 데이터를 넣을 때 배열 사이즈보다 크면 배열을 늘린다.
		if(this.arraySize == this.size) {
			grow();
		}
		
		// 큐에 데이터를 넣는다.
		this.data[lastIndex] = (Object) data;
		
		// 인덱스를 다시 지정
		this.lastIndex++;
		this.size++;
	}
	
	// 배열 사이즈 늘리기
	private void grow() {
		arraySize += defaultSize;
		Object[] newData = new Object[arraySize];
		
		for(int i=0; i<this.data.length; i++) {
			if(this.data[i] == null) break;
			
			newData[i] = this.data[i]; 
		}
		
		data = newData;
	}
	
	// 출력
	public void print() {
		for(int i=firstIndex; i<firstIndex+size; i++) {
			System.out.println(data[i]);
		}
	}
	
	// 테스트
	public static void main(String[] ar) {
		
		Queue<String> queue = new Queue<String>();
		
		// 데이터 넣기
		queue.push("1");
		queue.push("2");
		queue.push("3");
		queue.push("4");
		queue.push("5");
		queue.push("6");
		queue.push("7");
		queue.push("8");
		queue.push("9");
		queue.push("10");
		queue.push("11");
		queue.push("12");
		queue.push("13");
		
		queue.print();
		
		// 데이터 빼기
		queue.pop();
		queue.pop();
		queue.pop();
		queue.pop();
		
		queue.print();
		
		
	}
}
