## Data Structure
- 기본 자료구조를 정리한 패키지
- 각 자료구조 클래스는 POJO 형태로 작성
- 플랫하게 만들어보기 위해 최대한 자바 API를 사용하지 않고 구현
- 자료구조의 기본적인 구성은 아래와 같다
	* insert : 데이터를 어떻게 저장하는가
	* search : 데이터를 어떻게 탐색하는가
	* delete : 데이터를 어떻게 삭제하는가

## Linear Structure (선형구조)
- 선형구조는 순서가 있는 자료구조로 순서성을 보장한다.
- 아래 클래스 들은 기본적으로 자동으로 배열 크기를 조정한다.
1. List
	- [DynamicArray](./DynamicArray.java) : 데이터 갯수에 따라 자동으로 리사이징하는 배열 클래스
	- [LinkedList](./LinkedList.java) : 기본 링크드리스트 자료구조 클래스
2. Stack
	- [ArrayStack](./ArrayStack.java) : 기본 스택 자료구조 클래스
3. Queue
	- [Queue](./Queue.java) : 기본 큐 자료구조 클래스
4. Deque
	- [Deque](./Deque.java) : 기본 덱 자료구조 클래스

## Non-Linear Structure (비선형구조)
- 비선형구조는 순서성을 보장하지않는 자료구조로 하나의 자료 뒤에 여러개의 자료가 존재할 수 있다.
1. Tree
	- [Binary Search Tree](./BinarySearchTree.java) : 기본 이진탐색트리 자료구조 클래스
2. Graph
3. HashTable
	- [HashTable](./HashTable.java) : 기본 해시테이블 자료구조 클래스