package com.lafin.knowledge.ds;

/**
 * 이진 탐색 트리 자료구조 클래스
 * 이진탐색트리는 왼쪽은 부모노드의 값보다 작은 값이고 오른쪽은 큰 값이 와야한다.
 * 값들의 비교가 일어나므로 Integer를 상속받은 클래스를 제네릭으로 설정
 * @author lafin
 */

public class BinarySearchTree<T extends Integer> {
	
	// 노드 클래스
	class Node<T extends Integer>{
		T data;
		Node<T> lnode;
		Node<T> rnode;
		
		public Node(T data){
			this.data = data;
			lnode = null;
			rnode = null;
		}
	}
	
	// 최상위 노드
	Node<T> rootNode;
	
	// 생성자
	public BinarySearchTree() {
		rootNode = null;
	}
	
	// 트리가 비어있는지 검사
	public boolean isEmpty() {
		return rootNode == null;
	}
	
	// 트리에 노드 추가 
	// 재귀함수로 구현
	public void insertNode(T data) {
		rootNode = insertNode(rootNode, data);
	}
	
	// 트리에 값을 넣는다
	private Node insertNode(Node node, T data) {
		
		// 노드가 없는경우 새로추가
		if(node == null) {
			node = new Node<T>(data);
			return node;
		}else {
			
			if(data < node.data) {
				node.lnode = insertNode(node.lnode, data);
			}else if(data > node.data) {
				node.rnode = insertNode(node.rnode, data);
			}
			
			return node;
		}
	}
	
	// 트리에 값을 지운다
	// 재귀함수로 구현
	// 노드를 지울 때는 3가지 상황이 있고 아래와 같다
	// 1. 자식노드가 없을때
	// 2. 자식노드가 하나 연결되어 있을 때
	// 3. 자식노드가 두개 연결되어 있을 때
	public void deleteNode(T data) {
		rootNode = deleteNode(rootNode, data);
	}
	
	// 트리에 값을 삭제한다
	private Node deleteNode(Node node, T data) {
		
		// 노드가 없는경우 바로 반환
		if(node == null) {
			return node;
		}else {
			
			// 데이터가 크거나 작은 경우 각 왼쪽, 오른쪽에 노드에서 재귀를 통해 탐색을 계속 진행
			if(data < node.data) {
				node.lnode = deleteNode(node.lnode, data);
			}else if(data > node.data) {
				node.rnode = deleteNode(node.rnode, data);
			}else {
				// 자식노드가 없을 때는 그냥 null 반환
				if(node.lnode == null && node.rnode == null) return null;
				// 왼쪽 노드가 없는 경우
				else if(node.lnode == null) return node.rnode;
				// 오른쪽 노드가 없는 경우
				else if(node.rnode == null) return node.lnode;
				
				// 둘다 있는경우 오른쪽의 노드에서 최소값(가장 왼쪽에 있는 값)을 구해온다 (왼쪽의 값으로 넣어도 되나 오른쪽으로 선택함)
				node.data = findMinimum(node.rnode);
				node.rnode = deleteNode(node.rnode, (T) node.data);
			}
			
			return node;
		}
	}
	
	// 최소값 가져오기
	private T findMinimum(Node node) {
		T min = (T) node.data;
		
		while(node.lnode != null) {
			min = (T) node.lnode.data;
			node = node.lnode;
		}
		
		return min;
	}
	
	// 트리에 값을 찾는다
	public Node search(Node root, T data) {
		
		// 원하는 값을 찾으면 해당 노드를 반환
		if(root == null || root.data == data) {
			return root;
		}
		
		// 현재 노드의 데이터가 찾고자하는 값보다 작다면 left node에서 다시 찾게끔 재귀호출
		if(root.data > data) return search(root.lnode, data);
		
		// 현재 노드의 데이터가 찾고자하는 값보다 크다면 right node에서 다시 찾게끔 재귀호출
		return search(root.rnode, data);
	}
	
	
	// 출력
	public void print() {
		inOrder(rootNode);
		System.out.println();
	}
	
	// 중위 순회
	public void inOrder(Node node) {
		if(node != null) {
			inOrder(node.lnode);
			System.out.print(node.data + " ");
			inOrder(node.rnode);
		}
	}
	
	// 테스트
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		bst.insertNode(20);
		bst.insertNode(15);
		bst.insertNode(10);
		bst.insertNode(9);
		bst.insertNode(17);
		bst.insertNode(19);
		bst.insertNode(1);
		bst.insertNode(12);
		bst.insertNode(35);
		bst.insertNode(25);
		
		bst.print();
		
		bst.deleteNode(10);
		bst.deleteNode(17);
		bst.deleteNode(2);
		
		bst.print();
	}
}
