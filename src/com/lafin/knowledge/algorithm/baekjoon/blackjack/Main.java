package com.lafin.knowledge.algorithm.baekjoon.blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.acmicpc.net/problem/2798
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 게임 정보 받기
        String dealer = br.readLine();
        String[] race = dealer.split(" ");

        int cardCount = Integer.parseInt(race[0]);
        int limit = Integer.parseInt(race[1]);

        // 카드 받기
        String player = br.readLine();
        String[] cards = player.split(" ");

        List<Integer> totalList = new ArrayList<>();

        // 카드의 전체 경우의 수 체크
        for (int i = 0; i < cards.length; i++) {
            
            for (int j = i + 1; j < cards.length; j++) {
                
                for (int k = j + 1; k < cards.length; k++) {
                    
                    int total = Integer.parseInt(cards[i]) + Integer.parseInt(cards[j]) + Integer.parseInt(cards[k]);

                    if (total <= limit) {
                        totalList.add(total);
                    }
                }
            }
        }

        Collections.sort(totalList, Collections.reverseOrder());

        System.out.println(totalList.get(0));
    }
}
