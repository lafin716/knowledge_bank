package com.lafin.knowledge.ds;

/**
 * 해시테이블 클래스
 * 해시코드는 예제이므로 int로 구현
 * 자바의 해시테이블은 Seperate Chaining으로 구현되어있고 버킷은 링크드리스트로 되어있지만 버킷 데이터가 많아지면 Red-black 트리를 사용함
 * 예제는 그냥 링크드리스트로 구현
 * @author lafin
 * @param <K> 해시의 키값
 * @param <V> 해시 데이터
 */
public class HashTable<K,V>{
	
	// 노드 클래스
	@SuppressWarnings("hiding")
	class Node<K,V> {
		// 노드의 해시 키값
		final int hash;
		// 노드의 키값
		final K key;
		// 노드의 데이터값
		V value;
		// 다음 노드 객체
		Node<K,V> next;
		
		// 생성자에서 노드값을 설정
		// next값은 어차피 put할 때 지정되므로 생성자에선 필요없다고 판단
		Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = null;
        }
		
		public String toString() {
			return key.toString() + "=" + value.toString();
		}
	}
	
	// 배열의 크기
	private int size;
	
	// 배열 데이터
	private Node<K,V>[] table;
	
	// 기본 크기
	private final int DEFAULT_CAPACITY = 20;
	
	// 생성자
	public HashTable() {
		init();
	}
	
	// 초기화
	@SuppressWarnings("unchecked")
	public void init() {
		table = (Node<K,V>[]) new Node[DEFAULT_CAPACITY];
		size = 0;
	}
	
	// 키 값을 해시코드로 변환
	private int hash(K key) {
		return key.hashCode();
	}
	
	// 버킷의 인덱스를 구하는 메소드
	private int getIndex(int hash) {
		// 해시코드는 배열 크기 이상으로만 나올 수 밖에 없으므로 실제 해시테이블의 길이로 나눈 나머지 값을 인덱스로 써야함
		return (int)(hash % table.length);
	}
	
	// 데이터 저장
	public void put(K key, V value) {
		int hash = hash(key);
		int index = getIndex(hash);
		Node<K,V> headNode = table[index];
		
		System.out.println("key : " + key + " index : " + index + " hash : " + hash);
		
		// 인덱스 데이터가 없는 경우 바로 노드를 추가
		if(headNode == null) {
			table[index] = newNode(hash, key, value);
			size++;
		}else {
			// 테이블에 해당 키 값이 있는지 확인
			Node<K,V> prevNode = headNode;
			Node<K,V> tmpNode = headNode;
			
			do {
				if(tmpNode.key.equals(key)) {
					tmpNode.value = value;
					break;
				}
				
				prevNode = tmpNode;
				tmpNode = tmpNode.next;
			}while(tmpNode != null);
			
			if(tmpNode == null) {
				prevNode.next = newNode(hash,key,value);
				size++;
			}	
		}
	}
	
	// 데이터 빼기
	public V get(K key) {
		Node<K,V> node = searchNode(key);
		
		if(node != null && node.value != null) {
			return node.value;
		}else {
			return null;
		}		
	}
	
	// 데이터 지우기
	public void remove(K key) {
		int hash = hash(key);
		int index = getIndex(hash);
		Node headNode = table[index];
		
		if(headNode == null) {
			return;
		}else {
			
			// 이전 노드
			Node prevNode = null;
			
			// 노드의 키값이 맞을 떄 까지 반복
			while(headNode != null && !headNode.key.equals(key)) {
				prevNode = headNode;
				headNode = headNode.next;
			}
			
			// headNode가 null인 경우 데이터를 못찾은 것이므로 바로 리턴
			if(headNode == null) return;
			
			// prevNode가 null인 경우 제일 첫번째 노드이므로 table에 바로 세팅
			if(prevNode == null) {
				table[index] = headNode.next;
			}else {
				// 데이터가 있는 경우 해당 키값을 찾은 것이므로 이전노드의 next 값을 현재노드의 next값으로 다시 연결
				prevNode.next = headNode.next;
			}			
		}		
	}
	
	// 키가 존재하는지 여부
	public boolean containsKey(K key) {
		return searchNode(key) == null ? false : true;
	}
	
	// 키 값으로 노드 찾기
	// null을 리턴하는경우 해당 키값으로 등록 된 노드가 없는 것을 의미
	private Node<K,V> searchNode(K key){
		int hash = hash(key);
		int index = getIndex(hash);
		Node<K,V> node = table[index];
		
		// 맨 처음노드가 같은 키값인 경우 바로 리턴
		if(node.key == key) {
			return node;
		}	
		
		// 맨 마지막의 노드를 가져오기 위한 반복문
		// 찾는 중간에 키값이 같으면 반복문 종료
		while(node != null) {
			if(node.key == key) break;
			node = node.next;
		}
		
		return node;		
	}
		
	// 새로운 노드 생성
	// 노드 검색 시 해당 키의 데이터는 없는데 데이터가 하나라도 있는 경우 마지막 노드로 추가해주기 위함
	private Node<K,V> newNode(int hash, K key, V value) {
		return new Node<K,V>(hash, key, value);
	}
	
	// 키 값으로 노드 찾기
	// searchNode에서 null로 리턴 되었을 때 해당 
	
	// 데이터 크기
	public int size() {
		return size;
	}
	
	// 출력
	public void print() {
		// 테이블 배열만큼 반복
		for(int i=0; i<table.length; i++) {
			Node<K,V> tmpNode = table[i];
			
			// tmpNode가 null 인 경우 한번도 데이터 삽입이 일어난 적이 없는 것
			if(tmpNode == null) continue;
			
			System.out.print("\""+i+"\" : [" + tmpNode.toString());
			
			// 노드의 next 값이 없을때까지 반복
			while(tmpNode.next != null) {
				tmpNode = tmpNode.next;
				System.out.print(","+tmpNode.toString());
			}
			System.out.print("]");
			System.out.println();
		}
	}
	
	// 테스트
	public static void main(String[] ar) {
		HashTable<String, String> map = new HashTable<String, String>();
		
		// 초기값 세팅
		for(int i=0; i<10; i++) {
			map.put(Integer.toString(i), Integer.toString(i));
		}
		
		map.put("test1", "22222222");
		map.put("test1", "testtest");
		map.put("test2", "3333333");
		map.put("test3", "44444444");
		map.put("test4", "555555555");
		System.out.println(map.get("test5"));
		
		// 값을 치환하여 확인
		map.put("1", "1번 덮어쓰기");
		map.put("test1", "test1 바뀜");		
		System.out.println(map.get("test3"));
		
		System.out.println("중간 출력 :: ");
		map.print();
		
		// 키 포함 여부
		System.out.println("test1 키 포함 여부 : " + map.containsKey("test1"));
		System.out.println("pjw 키 포함 여부 : " + map.containsKey("pjw"));
		
		// 데이터 삭제
		map.remove("test3");
		map.remove("2");
		map.remove("3");
		map.remove("test4");
		
		// 해시테이블 총 갯수
		System.out.println("size: " + map.size());
		
		// 해시테이블 전체 출력
		// 인덱스 번호는 해시코드에 의해 랜덤하게 지정되므로 순서성을 보장하지 않음
		System.out.println("최종 출력 :: ");
		map.print();
		
	}
}
