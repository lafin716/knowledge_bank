package com.lafin.knowledge.ds;

import java.util.List;

import java.util.ArrayList;

/**
 * 최대힙 자료구조
 * 
 * [인덱스 계산법]
 * 부모노드 = 자식노드 / 2
 * 왼쪽 자식노드 = 부모노드 * 2
 * 오른쪽 자식노드 = 부모노드 * 2 + 1
 */
public class MaxHeap {

    private List<Integer> data;

    public MaxHeap() {
        this.data = new ArrayList<>();
        this.data.add(100000);
    }

    public void add(int n) {

        // 데이터를 삽입
        data.add(n);
        // 방금 삽입한 데이터 인덱스 번호
        int p = data.size() - 1;

        // 루트 직전 자식노드까지 탐색, 부모 노드보다 값이 큰지 검사
        while (p > 1 && data.get(p / 2) < data.get(p)) {
            // 부모노드 값과 자식 노드 값을 스왑
            int temp = data.get(p / 2);
            data.set(p/2, data.get(p));
            data.set(p, temp);
            p = p / 2;
        }
    }

    public int pop() {
        if (data.size() - 1 < 1) return 0;

        // 루트 노드를 빼온다
        int delete = data.get(1);

        // 제일 마지막 리프노드를 루트노드에 스왑
        data.set(1, data.get(data.size() - 1));
        data.remove(data.size() - 1);

        // 루트부터 다시 heapify 수행
        int pos = 1;
        while ((pos * 2) < data.size()) {
            // 왼쪽 자식 노드
            int max = data.get(pos * 2);
            int maxPos = pos * 2;

            // 오른쪽 자식노드가 존재하고, 왼쪽보다 큰 경우 오른쪽 노드 기준으로 변경
            if ((pos * 2 + 1) < data.size() && max < data.get(pos*2+1)) {
                max = data.get(pos * 2 + 1);
                maxPos = pos * 2 + 1;
            }

            // 부모노드가 자식보다 크면 heapify 종료
            if (data.get(pos) > max) {
                break;
            }

            // 작은 경우 자식노드와 스왑처리 후 다음 부모노드로 설정
            int temp = data.get(pos);
            data.set(pos, data.get(maxPos));
            data.set(maxPos, temp);
            pos = maxPos;
        }

        return delete;
    }

    public boolean isEmpty() {
        return data.size() <= 1;
    }

    public int size() {
        return data.size();
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        heap.add(3);
        heap.add(10);
        heap.add(5);
        heap.add(6);
        heap.add(2);
        heap.add(8);
        heap.add(11);
        heap.add(55);
        heap.add(1);
        heap.add(4);

        System.out.println("size : " + heap.size());

        while (!heap.isEmpty()) {
            System.out.println(heap.pop());
        }
    }
}
