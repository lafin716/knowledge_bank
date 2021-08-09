package com.lafin.knowledge.algorithm.baekjoon.organiccabbage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {0,0,1,-1};

    static int[] dy = {1,-1,0,0};

    static int width;
    
    static int height;

    static int[][] map;

    static boolean[][] visited;

    static int wormsCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseCount = Integer.parseInt(br.readLine());
        
        // 케이스 갯수만큼 반복
        for (int i = 0; i < caseCount; i++) {

            String[] cabbageField = br.readLine().split(" ");
            int x = Integer.parseInt(cabbageField[0]);
            int y = Integer.parseInt(cabbageField[1]);
            int cabbageCount = Integer.parseInt(cabbageField[2]);

            // 배추밭 초기화
            wormsCount = 0;
            width = x;
            height = y;
            map = new int[x][y];
            visited = new boolean[x][y];
            
            // 배추가 심어진 곳 마킹 처리
            for (int j = 0; j < cabbageCount; j++) {
                String[] cabbageInfo = br.readLine().split(" ");
                int nx = Integer.parseInt(cabbageInfo[0]);
                int ny = Integer.parseInt(cabbageInfo[1]);

                map[nx][ny] = 1;
            }

            // bfs 수행
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < height; k++) {

                    if (map[j][k] == 1 && !visited[j][k]) {
                        wormsCount++;
                        bfs(j, k);
                    }
                }
            }

            System.out.println(wormsCount);
        }
    }

    static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{i, j});

        // 방문 처리
        visited[i][j] = true;

        // 큐가 비어있을 때까지
        while (!queue.isEmpty()) {
            int[] dir = queue.poll();
            int x = dir[0];
            int y = dir[1];
            
            // 상하좌우 살펴보기
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 인덱스 범위 내에서만
                if (nx >= 0 && ny >= 0 && nx < width && ny < height) {
                    // 방문여부 검사
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
