package com.lafin.knowledge.algorithm.baekjoon.b3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;


public class Main {

    class Pos {

        public int x;

        public int y;

        public Pos() {

        }

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 맵 정보 받기
        String[] mapInfo = br.readLine().split(" ");
        int R = Integer.parseInt(mapInfo[0]);
        int C = Integer.parseInt(mapInfo[1]);

        int[][] map = new int[R][C];

        Pos hogPosition = null;
        Pos beaverPosition = null;
        Pos waterPosition = null;

        for (int i = 0; i < R; i++) {
            String[] row = br.readLine().split("");

            for (int j = 0; j < C; j++) {
                String inputCode = row[j];
                int code = -1;

                if (inputCode.equals("D")) {
                    beaverPosition = new Pos(i, j);
                } else if (inputCode.equals("S")) {
                    hogPosition = new Pos(i, j);
                } else if (inputCode.equals("*")) {
                    waterPosition = new Pos(i, j);
                    code = 1;
                } else {
                    code = 0;
                }

                map[i][j] = code;
            }
        }
    }
}
