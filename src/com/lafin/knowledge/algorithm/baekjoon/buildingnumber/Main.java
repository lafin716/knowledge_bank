package com.lafin.knowledge.algorithm.baekjoon.buildingnumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static int size;

    static int[][] map;

    static boolean[][] visited;

    static int apartNo;

    static int[] aparts;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 빌딩 사이즈
        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        visited = new boolean[size][size];
        aparts = new int[size * size];

        // 연결 정보 세팅
        for (int i = 0; i < size; i++) {
            String edgeInput = br.readLine();
            String[] edgeInputArr = edgeInput.split("");

            for (int j = 0; j < size; j++) {
                int x = Integer.parseInt(edgeInputArr[j]);
                map[i][j] = x;
            }
        }

        // 전체 아파트를 순회하면서 세대가 있는 곳을 발견하면 bfs 수행하여 단지 구성
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (map[i][j] == 1 && !visited[i][j]) {
                    apartNo++;
                    bfs(i, j);
                }
            }
        }

        // 결과 배열 정렬
        Arrays.sort(aparts);
        System.out.println(apartNo);

        for (int i = 0; i < aparts.length; i++) {
            if (aparts[i] > 0) {
                System.out.println(aparts[i]);
            }
        }
    }

    static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();

        // 시작점을 큐에 넣는다
        queue.offer(new int[]{i, j});

        // 방문 처리
        visited[i][j] = true;
        aparts[apartNo]++;

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
                if (nx >= 0 && ny >= 0 && nx < size && ny < size) {

                    // 방문여부 검사
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        aparts[apartNo]++;
                    }
                }
            }
        }
    }
}
