package com.lafin.knowledge.algorithm.programmers;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * [해시] 베스트 앨범에 수록될 앨범들의 정렬
 * @author lafin
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 * 
 * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요
 * 
 *  genres	                                        plays	                    return
 *  ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
  */
public class BestAlbum {
	
	public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        // 고유번호 맵
        HashMap<String, ArrayList<Integer>> seqList = new HashMap<>();
        
        // 장르별 재생 수 맵
        HashMap<String, Integer> playCnt = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
        	
        	// 리스트에 해당 장르의 고유번호를 저장
        	ArrayList<Integer> currentList = seqList.get(i) == null ? new ArrayList<Integer>() : seqList.get(i);
        	currentList.add(i);
        	
        	// 재생 수를 누적하여 저장
        }
        
        return answer;
    }
	
	
	public static void main(String[] args) {
		BestAlbum ba = new BestAlbum();
		
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		int[] rank = ba.solution(genres, plays);
		System.out.println("정답 : " + rank);
	}
}
