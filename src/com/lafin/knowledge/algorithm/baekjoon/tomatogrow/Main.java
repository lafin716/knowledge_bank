package com.lafin.knowledge.algorithm.baekjoon.tomatogrow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {0, 0, -1, 1};

    static int[] dy = {-1, 1, 0, 0};

    static int m;

    static int n;

    static int[][] map;

    static int[][] dayMap;

    static boolean[][] visited;

    static int day;
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] caseInfo = br.readLine().split(" ");
        m = Integer.parseInt(caseInfo[0]);
        n = Integer.parseInt(caseInfo[1]);
        map = new int[m][n];
        dayMap = new int[m][n];
        visited = new boolean[m][n];

        // 익은 토마토 정보
        Queue<int[]> wellTomatos = new LinkedList<>();

        // 맵 생성
        for (int i = 0; i < n; i++) {
            String[] mapLine = br.readLine().split(" ");

            for (int j = 0; j < mapLine.length; j++) {
                int tomatoStatus = Integer.parseInt(mapLine[j]);
                map[j][i] = tomatoStatus;

                if (tomatoStatus == 1) {
                    wellTomatos.add(new int[]{j, i});
                }
            }
        }

        // bfs 실행
        bfs(wellTomatos);


        // max 값 체크
        System.out.println(getMaxday());
    }

    static void bfs(Queue<int[]> queue) {
        
        while (!queue.isEmpty()) {
            int[] dir = queue.poll();
            int x = dir[0];
            int y = dir[1];
            visited[x][y] = true;
            if (map[x][y] < 1) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
    
                if (check(nx, ny)) {
                    visited[nx][ny] = true;
                    map[nx][ny]++;
                    dayMap[nx][ny] = dayMap[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }

            // print();
        }
    }

    static int getMaxday() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[j][i] == 0) return -1;
                max = Math.max(max, dayMap[j][i]);
            }
        }

        return max;
    }

    static void print() {
        System.out.println("=============================");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[j][i]);
            }
            System.out.println();
        }
        System.out.println("/////////////////////////////");
    }

    static boolean check(int x, int y) {
        if (x >= 0 && x < m && y >= 0 && y < n) { 
            if (map[x][y] == 0 && !visited[x][y]) {
                return true;
            }
        }       

        return false;
    }
}
