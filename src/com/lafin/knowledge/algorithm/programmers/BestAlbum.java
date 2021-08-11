package com.lafin.knowledge.algorithm.programmers;

import java.util.*;
import java.util.Map.*;
import java.util.stream.IntStream;

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

	class Album {
		private int idx;
		private int plays;

		public Album(int idx, int plays) {
			this.idx = idx;
			this.plays = plays;
		}

		public int getIdx() {
			return idx;
		}

		public int getPlays() {
			return plays;
		}
	}
	
	public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 장르별 총 재생 횟수
        Map<String, Integer> genresStat = new HashMap<>();

		// 장르별 노래 정보 
		Map<String, List<Album>> albumInfo = new HashMap<>();

		// 장르, 재생횟수 만큼 반복
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

			// 장르별 재생 횟수 총 합을 구하기 위해 장르에 재생횟수를 누적합
            genresStat.put(genre, genresStat.getOrDefault(genre, 0) + play);

			// 장르별 노래 정보를 저장
			List<Album> albumList = albumInfo.getOrDefault(genre, new ArrayList<>());
			albumList.add(new Album(i, play));
			albumInfo.put(genre, albumList);
        }
        
        // 장르별 재생횟수 내림차순으로 정렬
		List<Entry<String, Integer>> statEntry = new ArrayList<>(genresStat.entrySet());
		Collections.sort(statEntry, new Comparator<Entry<String, Integer>>(){
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// 내림차순 정렬
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		// 재생 횟수가 큰 장르부터 2개씩 앨범을 고른다
		for(Entry<String, Integer> entry : statEntry) {
			int limit = 2;
			String genre = entry.getKey();

			List<Album> albumList = albumInfo.get(genre);
			albumList.sort(new Comparator<Album>(){
				@Override
				public int compare(Album o1, Album o2) {					
					return o2.getPlays() - o1.getPlays();
				}
			});

			for (Album album : albumList) {
				if (limit == 0) break;
				answer.add(album.getIdx());
				limit--;
			}
		}
        
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
	
	
	public static void main(String[] args) {
		BestAlbum ba = new BestAlbum();
		
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		System.out.print("정답 : " );
		int[] rank = ba.solution(genres, plays);
		IntStream.of(rank).forEach(System.out::print);
		
	}
}
