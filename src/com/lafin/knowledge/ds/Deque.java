package com.lafin.knowledge.ds;

/**
 * 덱 자료구조 클래스
 * 스택과 큐를 특징을 동시에 가지고 있는 자료구조로 앞, 뒤에서 데이터를 삽입, 삭제 할 수있다.
 * @author lafin
 */
public class Deque<E> {
	
	// 데이터가 들어갈 노드 클래스
	class Node<E>{
		E data;
		Node llink;
		Node rlink;
		
		public Node(E data) {
			this.data = data;
		}
	}
	
	// 앞에 있는 노드 큐
	Node<E> front;
	
	// 뒤에 있는 노드 큐
	Node<E> rear;
	
	// 생성자
	public Deque() {
		front = null;
		rear = null;
	}
	
	// 큐가 비어있는지 검사
	public boolean isEmpty() {
		return front == null;
	}
	
	// 앞에 데이터 삽입
	public void insertFront(E data) {
		
		// 노드 생성
		Node<E> newData = new Node<E>(data);
		
		// 데이터가 비어있는지 검사
		if(isEmpty()) {
			// 비어있으면 초기 데이터 세팅
			// 처음 세팅되는 노드이므로 양쪽 노드는 null이다 
			front = newData;
			rear = newData;
			newData.llink = null;
			newData.rlink = null;					
		}else {
			// 새 노드의 오른쪽 값은 기존 front로 연결
			newData.rlink = front;
			newData.llink = null;
			
			// 데이터가 있는 경우 앞쪽 노드의 llink를 재설정
			front.llink = newData;		
			
			// 재설정 후 front는 새로 들어간 노드가 된다.
			front = newData;
		}
	}
	
	// 앞에 데이터 뽑아오기
	public E deleteFront() {
		// 노드가 하나도 없는 경우 그냥 리턴
		if(isEmpty()) return null;
		
		// 맨 앞에 노드의 rlink값이 front가 되게 한다.
		E data = front.data;
		if(front.rlink != null) {
			front = front.rlink;
			front.llink = null;
		}else {
			front = null;
			rear = null;
		}
		
		return data;
	}
	
	// 앞에 데이터 삭제
	public void removeFront() {
		// 노드가 하나도 없는 경우 그냥 리턴
		if(isEmpty()) return;
		
		// 맨 앞에 노드의 rlink값이 front가 되게 한다.
		E data = front.data;
		if(front.rlink != null) {
			front = front.rlink;
			front.llink = null;
		}else {
			front = null;
			rear = null;
		}
	}
	
	// 앞에 데이터만 조회 삭제하지 않음	
	public E peekFront() {
		if(isEmpty()) {
			return null;
		}else {
			return front.data;
		}
	}
	
	// 뒤에 데이터 삽입
	public void insertRear(E data) {
		
		// 노드 생성
		Node<E> newData = new Node<E>(data);
		
		// 데이터가 비어있는지 검사
		if(isEmpty()) {
			// 데이터가 비어있는 경우 뒤에 새 데이터 설정
			front = newData;
			rear = newData;			
			newData.llink = null;
			newData.rlink = null;
		}else {
			
			// 새 노드의 오른쪽 값은 기존 rear로 연결
			newData.rlink = null;
			newData.llink = rear;
			
			// 데이터가 있는 경우 뒤쪽 노드의 rlink를 재설정
			rear.rlink = newData;		
			
			// 재설정 후 rear는 새로 들어간 노드가 된다.
			rear = newData;
		}
		
	}
	
	// 뒤에 데이터 뽑아오기
	public E deleteRear() {
		
		// 데이터가 비어있음
		if(isEmpty()) return null;
		
		// 맨 뒤의 데이터 가져옴
		E data = rear.data;
		// 삭제처리
		if(rear.llink == null) {
			front = null;
			rear = null;
		}else {
			rear = rear.llink;
			rear.rlink = null;
		}
		
		return data;
	}
	
	// 뒤에 데이터 삭제
	public void removeRear() {
		// 데이터가 비어있음
		if(isEmpty()) return;
		
		// 맨 뒤의 데이터 가져옴
		E data = rear.data;
		// 삭제처리
		if(rear.llink == null) {
			front = null;
			rear = null;
		}else {
			rear = rear.llink;
			rear.rlink = null;
		}
	}
	
	// 뒤에 데이터만 조회 삭제하지 않음	
	public E peekRear() {
		if(isEmpty()) {
			return null;
		}else {
			return rear.data;
		}
	}
	
	// 출력
	public void print() {
		
		if(isEmpty()) {
			System.out.println("덱이 비어있습니다.");
		}else {
			Node node = front;
			while(node != null){
				System.out.print(node.data + ", ");
				node = node.rlink;
			}
			System.out.println();
		}
	}
	
	
	// 테스트
	public static void main(String[] args) {
		Deque<String> deque = new Deque<String>();
        
		deque.insertFront("A");
		deque.insertFront("B");
		deque.insertFront("C");
		deque.deleteFront();
		deque.insertFront("D");
		deque.insertFront("E");		
		deque.print();
        
		deque.insertRear("1");
		deque.insertRear("2");
		deque.insertRear("3");
		deque.deleteRear();
		deque.insertRear("4");
		deque.insertRear("5");
		deque.deleteRear();
		deque.print();

	}
}
