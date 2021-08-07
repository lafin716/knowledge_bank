package com.lafin.knowledge.ds;

/**
 * 링크드리스트 클래스 
 * 기본자료구조인 링크드리스트를 구현
 * 제네릭클래스로 생성하여 리스트요소 타입을 확장성있게 구현
 * @author lafin
 *
 */
public class LinkedList<T> {
	
	// 처음 노드객체
	Node headNode;
	
	// 현재 노드객체
	Node currentNode;
	
	// 리스트 요소
	class Node{
		
		// 요소값
		T data;		
		// 다음 노드객체를 저장하여 연결
		Node next;
		
		// 생성자에서 노드 생성시 요소값 설정
		Node(T data){
			this.data = data;
		}
	}
	
	// 리스트에 요소를 추가하는 함수
	public void add(T data) {
		Node newNode = new Node(data);
		
		// 만약 마지막에 등록된 노드가 없는 경우 최초노드 설정
		if(headNode == null) {
			headNode = newNode;			
		}else {
			// 마지막 노드를 불러온다
			Node lastNode = currentNode;
			
			// 마지막 노드의 다음객체값을 새로 생성한 노드로 지정
			lastNode.next = newNode;
		}
		
		// 현재 노드객체를 새로만든 객체로 바꾼다.
		currentNode = newNode;
	}
	
	// 리스트 노드를 삭제한다.
	public void delete() {
		
		// 링크드리스트는 단방향으로 연결되어 있기 때문에 가장 마지막노드까지 찾은 후 삭제해야한다.
		Node tempHeadNode;
		Node tempNextNode;
		
		// 첫번째 노드가 null 인경우 모두 삭제된 것이므로 리턴
		if(headNode == null) {
			return;
		} else {
			// 최초 노드부터 설정하여 탐색 시작
			tempHeadNode = headNode;
			tempNextNode = headNode.next;
			
			// 다음 노드의 다음노드가 null 인경우 현재노드의 다음노드가 마지막인 것을 알 수있음.
			while(tempNextNode.next != null) {
				tempHeadNode = tempNextNode;
				tempNextNode = tempNextNode.next;
			}
			
			// 위 반복문이 끝나면 마지막 노드가 되므로 연결을 해제
			tempHeadNode.next = null;
			
			// 현재노드를 임시노드로 설정
			currentNode = tempHeadNode;
		}
	}
	
	// 리스트를 출력한다.
	public void print() {
		Node node = headNode;
		
		while(node != null) {
			System.out.print(node.data.toString() + " -> ");
			node = node.next;
		}
		System.out.println();
	}
	
	// 테스트
	public static void main(String[] ar) {
		LinkedList<String> linkedList = new LinkedList<String>();
		
		linkedList.add("일요일");
		linkedList.add("월요일");
		linkedList.add("화요일");
		linkedList.add("수요일");
		linkedList.delete();
		linkedList.add("목요일");
		linkedList.add("금요일");
		linkedList.delete();
		linkedList.delete();
		linkedList.add("토요일");
		linkedList.print();
	}
}
