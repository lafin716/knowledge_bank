package com.lafin.knowledge.algorithm.programmers;

import java.util.*;

public class ConnectIsland {

    class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int[] parent;
    static PriorityQueue<Edge> queue;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        parent = new int[n];
        queue = new PriorityQueue<>();

        for (int[] edge : costs) {
            queue.offer(new Edge(edge[0], edge[1], edge[2]));
        }

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();

            if (find(edge.from) == find(edge.to)) {
                continue;
            }

            union(edge.from, edge.to);
            answer += edge.cost;
        }

        return answer;
    }

    public int find(int n) {
        if (parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    public static void main(String[] args) {
        ConnectIsland ci = new ConnectIsland();

        System.out.println("expect: 4 \nresult: " + ci.solution(4,
                new int[][]{
                        {0,1,1},
                        {0,2,2},
                        {1,2,5},
                        {1,3,1},
                        {2,3,8}
                }));
    }


}
