package com.lafin.knowledge.algorithm.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/1260
 */
public class Main {

    static int nodeCount;

    static int edgeCount;

    static int start;

    static int[][] connect;

    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] inputArr = input.split(" ");

        // 그래프 정보
        nodeCount = Integer.parseInt(inputArr[0]);
        edgeCount = Integer.parseInt(inputArr[1]);
        start = Integer.parseInt(inputArr[2]);

        // 간선연결 정보
        connect = new int[1001][1001];

        // 확인 여부
        checked = new boolean[1001];
        
        // 간선 갯수 만큼 입력 받기
        for (int i = 0; i < edgeCount; i++) {
            String edgeInput = br.readLine();
            String[] edgeInputArr = edgeInput.split(" ");

            int x = Integer.parseInt(edgeInputArr[0]);
            int y = Integer.parseInt(edgeInputArr[1]);

            connect[x][y] = 1;
            connect[y][x] = 1;
        }

        // dfs 수행
        dfs(start);

        // bfs 수행 전 초기화
        System.out.println();
        checked = new boolean[1001];

        // bfs 수행
        bfs();
    }

    // dfs 는 재귀로 돌릴것이기 때문에 인자값을 받는다
    static void dfs(int n) {

        // 첫 노드는 방문 체크 후 먼저 출력
        checked[n] = true;
        System.out.print(n + " ");

        for (int i = 1; i <= nodeCount; i++) {
            if (connect[n][i] == 1 && checked[i] == false) {
                dfs(i);
            }
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        // 시작점을 큐에 넣는다
        queue.offer(start);

        // 방문 처리
        checked[start] = true;
        System.out.print(start + " ");

        // 큐가 비어있을 때까지
        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int j = 1; j <= nodeCount; j++) {

                // 간선이 연결 되어있고 방문한 적 없으면 큐에 넣는다
                if (connect[temp][j] == 1 && checked[j] == false) {
                    queue.offer(j);

                    // 그리고 방문 처리 한다
                    checked[j] = true;
                    System.out.print(j + " ");
                }
            }
        }
        
    }
}
