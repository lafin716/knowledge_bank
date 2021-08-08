package com.lafin.knowledge.algorithm.baekjoon.warmvirus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/2606
 */
public class Main {

    static int start = 1;

    static int computerCount;

    static int edgeCount;

    static int[][] connect = new int[101][101];

    static boolean[] checked = new boolean[101];

    static int connectedNodeCount = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 컴퓨터 갯수, 간선 갯수 
        computerCount = Integer.parseInt(br.readLine());
        edgeCount = Integer.parseInt(br.readLine());

        // 연결 정보 세팅
        // 1번을 통해 감염이 
        for (int i = 0; i < edgeCount; i++) {
            String edgeInput = br.readLine();
            String[] edgeInputArr = edgeInput.split(" ");

            int x = Integer.parseInt(edgeInputArr[0]);
            int y = Integer.parseInt(edgeInputArr[1]);

            connect[x][y] = 1;
            connect[y][x] = 1;
        }

        bfs();

        System.out.println(connectedNodeCount);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        // 시작점을 큐에 넣는다
        queue.offer(start);

        // 방문 처리
        checked[start] = true;

        // 큐가 비어있을 때까지
        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int j = 1; j <= computerCount; j++) {

                // 간선이 연결 되어있고 방문한 적 없으면 큐에 넣는다
                if (connect[temp][j] == 1 && checked[j] == false) {
                    queue.offer(j);

                    // 그리고 방문 처리 한다
                    checked[j] = true;
                    connectedNodeCount++;
                }
            }
        }
        
    }
    
}
