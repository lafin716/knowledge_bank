package com.lafin.knowledge.ds;

interface Stack<E>{
    boolean isEmpty();
    boolean isFull();
    void push(E obj);
    E pop();
    E peek();
    void clear();
}

public class ArrayStack<T> implements Stack<T> {

    // 스택의 고정 크기
    int initSize;

    // 스택의 실제 크기
    int stackSize;

    // 마지막 위치의 인덱스
    int lastIndex;

    // 스택 데이터
    Object[] data;

    public ArrayStack(int size){
        init(size);
    }

    // 초기화 메소드
    public void init(int size){
        initSize = size;
        stackSize = 0;
        lastIndex = -1;
        data = new Object[size];
    }

    @Override
    public boolean isEmpty() {
        return stackSize == 0;
    }

    @Override
    public boolean isFull() {
        return data.length == stackSize;
    }

    @Override
    public void push(Object obj) {
        if(isFull()) return;
        ++lastIndex;
        data[lastIndex] = obj;
        stackSize++;
    }

    @Override
    public T pop() {
        if(isEmpty()) return null;

        T tempData = (T) data[lastIndex];
        --stackSize;

        data[lastIndex] = null;
        lastIndex--;

        return tempData;
    }

    @Override
    public T peek() {
        if(isEmpty()) return null;
        return (T) data[lastIndex];
    }

    @Override
    public void clear() {
        init(initSize);
    }
    
    public int size() {
    	return stackSize;
    }
    
    public int realSize() {
    	return data.length;
    }

    public static void main(String[] ar){
        int size = 10;
        ArrayStack<String> stack = new ArrayStack<String>(size);

        stack.push("첫번째");
        stack.push("두번째");
        stack.push("세번째");
        stack.push("네번째");
        stack.push("다섯번째");
        stack.push("여섯번째");
        stack.push("일곱번째");
        stack.push("여덟번째");
        stack.push("아홉번째");
        stack.push("열번째");
        stack.push("열한번째");
        stack.push("열두번째");
        stack.pop();
        stack.pop();
        
        System.out.println("데이터 사이즈 : " + stack.size());
        System.out.println("배열 사이즈 : " + stack.realSize());

        stack.pop();
        stack.pop();
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
        System.out.println(stack.pop());
        System.out.println(stack.peek());

    }


}
