package com.lafin.knowledge.ds;

import java.util.List;

import java.util.ArrayList;

/**
 * 최소힙 자료구조
 * 
 * [인덱스 계산법]
 * 부모노드 = 자식노드 / 2
 * 왼쪽 자식노드 = 부모노드 * 2
 * 오른쪽 자식노드 = 부모노드 * 2 + 1
 */
public class MinHeap {
    private List<Integer> data;

    public MinHeap() {
        this.data = new ArrayList<>();
        this.data.add(100000);
    }

    public void add(int n) {
        data.add(n);
        int p = data.size() - 1;

        while (p > 1 && data.get(p / 2) > data.get(p)) {
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
            int min = data.get(pos * 2);
            int minPos = pos * 2;

            // 오른쪽 자식노드가 존재하고, 왼쪽보다 작은 경우 오른쪽 노드 기준으로 변경
            if ((pos * 2 + 1) < data.size() && min > data.get(pos*2+1)) {
                min = data.get(pos * 2 + 1);
                minPos = pos * 2 + 1;
            }

            // 부모노드가 자식보다 작으면 heapify 종료
            if (data.get(pos) < min) {
                break;
            }

            // 작은 경우 자식노드와 스왑처리 후 다음 부모노드로 설정
            int temp = data.get(pos);
            data.set(pos, data.get(minPos));
            data.set(minPos, temp);
            pos = minPos;
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
        MinHeap heap = new MinHeap();
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
