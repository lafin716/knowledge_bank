package com.lafin.knowledge.algorithm.baekjoon.mazeadventure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {0,0,1,-1};

    static int[] dy = {1,-1,0,0};

    static int n;

    static int m;

    static int[][] map;

    static boolean[][] visited;

    static int[][] distance;

    static int move;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] caseInfo = br.readLine().split(" ");
        n = Integer.parseInt(caseInfo[0]);
        m = Integer.parseInt(caseInfo[1]);
        map = new int[n][m];
        visited = new boolean[n][m];
        distance = new int[n][m];

        // 맵 생성
        for (int i = 0; i < n; i++) {
            String[] mapLine = br.readLine().split("");

            for (int j = 0; j < mapLine.length; j++) {
                if (mapLine[j].equals("1")) {
                    map[i][j] = 1;
                }
            }
        }

        // bfs 실행
        bfs();

        System.out.println(distance[n - 1][m - 1]);
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        distance[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] dir = queue.poll();
            int x = dir[0];
            int y = dir[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
    
                if (check(nx, ny)) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;

                    // 이전 노드의 거리에서 1씩 더한다
                    distance[nx][ny] = distance[x][y] + 1;
                }
            }
        }
    }

    static boolean check(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < m) { 
            if (map[x][y] == 1 && !visited[x][y]) {
                return true;
            }
        }       

        return false;
    }
}
