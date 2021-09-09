package com.lafin.knowledge.algorithm.programmers;

import java.util.PriorityQueue;

public class SpicyMaker {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i : scoville) {
            heap.add(i);
        }

        while (heap.peek() < K) {
            int min = heap.poll();
            int min2 = heap.poll();
            int newFood = min + (min2 * min2);

            heap.add(newFood);
            answer++;
        }

        
        return answer;
    }

    public static void main(String[] args) {
        SpicyMaker sm = new SpicyMaker();

        System.out.println(sm.solution(new int[]{2,3,9,1,10,12}, 7));
    }
    
}
