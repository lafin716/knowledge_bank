package com.lafin.knowledge.algorithm.programmers;

import java.util.*;

/**
 * 크레인 인형뽑기 게임
 * 게임개발자인 "죠르디"는 크레인 인형뽑기 기계를 모바일 게임으로 만들려고 합니다.
 * "죠르디"는 게임의 재미를 높이기 위해 화면 구성과 규칙을 다음과 같이 게임 로직에 반영하려고 합니다.
 * @author lafin
 * 
 * [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]	[1,5,3,5,1,2,1,4]	4
  */
public class CraneDollGame {

	public int solution(int[][] board, int[] moves) {
        int answer = 0;

        // 인형은 N * N 이기때문에 size는 통일
        int boxSize = board.length;
        
        // index별 인형 Queue
        List<Queue<Integer>> dollList = new ArrayList<>();
        
        // 바구니 Stack
        Stack<Integer> dollBucket = new Stack<>();

        // 인형 박스 탐색 시작
        for (int i = 0; i < boxSize; i++) {
            // i 번째 인형 큐
            Queue<Integer> queue = new LinkedList<>();

            for (int j = 0; j < boxSize; j++) {     
                // 인형이 없으면 건너뜀
                if (board[j][i] == 0) continue;

                // 인형을 큐에 넣는다
                queue.add(board[j][i]);
            }

            // 인형 리스트에 넣는다
            dollList.add(queue);
        }

        // 크레인을 움직인다
        for (int i = 0; i < moves.length; i++) {
            // 인덱스를 맞추기 위해 -1
            int movePoint = moves[i] - 1;

            // 잡은 인형
            Queue<Integer> currentQueue = dollList.get(movePoint);
            if (currentQueue.isEmpty()) continue;

            int pickedDoll = currentQueue.poll();

            // 바구니가 비어있으면 그냥 넣는다
            if (dollBucket.isEmpty()) {
                dollBucket.add(pickedDoll);
                continue;
            }

            // 바구니의 마지막 인형이 잡은 인형과 같으면 터뜨리고 카운트 +1
            int lastDoll = dollBucket.peek();
            if (pickedDoll == lastDoll) {
                dollBucket.pop();
                answer++;
            } else {
                dollBucket.add(pickedDoll);
            }
        }
        
        return answer;
    }
	
	
	public static void main(String[] args) {

        System.out.println("test : " + Math.ceil((float)12 / (float)8));

        float test = 12f / 8f;
        System.out.println("test : " + test);


		CraneDollGame game = new CraneDollGame();

        int[][] dolls = new int[][]{
            {0,0,0,0,0},
            {0,0,1,0,3},
            {0,2,5,0,1},
            {4,2,4,4,2},
            {3,5,1,3,1}
        };
        int[] moves = new int[]{1,5,3,5,1,2,1,4};
        
        // 기대결과 : 4
		System.out.print("정답 : " );
		int explodedDollCount = game.solution(dolls, moves);
		System.out.println(explodedDollCount);
	}
}
