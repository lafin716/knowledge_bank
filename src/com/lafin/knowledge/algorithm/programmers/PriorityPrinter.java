package com.lafin.knowledge.algorithm.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class PriorityPrinter {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 우선순위 내림차순으로 리스트 생성
        List<Integer> priorityList = Arrays.stream(priorities)
                                        .boxed()
                                        .sorted(Collections.reverseOrder())
                                        .collect(Collectors.toList());

        // 큐에 순차적으로 넣는다
        Queue<Paper> printQueue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            printQueue.add(new Paper(i, priorities[i]));
        }

        // 큐가 빌 때 까지 반복
        int count = 1;
        int priorityPoint = 0;
        while (!printQueue.isEmpty()) {
            Paper paper = printQueue.poll();
            
            System.out.print("count : " + count);
            System.out.print(", pl : " + priorityList.get(priorityPoint));
            System.out.print(" , curr : " + paper.priority);
            System.out.print(" , index : " + paper.index);
            System.out.println();
            
            if (paper.priority >= priorityList.get(priorityPoint) ) {
                if (paper.index == location) {
                    answer = count;
                    break;
                }

                count++;
                priorityPoint++;
            } else {
                printQueue.add(paper);    
            }
            
            
        }

        return answer;
    }
    
    class Paper {
        int index;
        int priority;

        public Paper(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

        public String toString() {
            return "index : " + index + ", priority : " + priority;
        }
    }

    public static void main(String[] args) {
        PriorityPrinter pr = new PriorityPrinter();

        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(pr.solution(priorities, location));

        int[] priorities2 = {1,1,9,1,1,1};
        int location2 = 0;
        System.out.println(pr.solution(priorities2, location2));
    }
    
}
