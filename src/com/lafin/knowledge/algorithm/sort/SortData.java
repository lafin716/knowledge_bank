package com.lafin.knowledge.algorithm.sort;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.HashSet;

public class SortData {

    // 중복되지 않는 랜덤 값 100개
    public static Set<Integer> getRandomUniqueDatas() {
        Set<Integer> result = new LinkedHashSet<>();

        // 랜덤하게 데이터를 넣는다
		while (result.size() < 100) {
			// 1 ~ 100 까지 랜덤한 수 생성
			int random = (int) ((Math.random() * 100) + 1);			
			result.add(random);
		}

        return result;
    }

    // 중복되지 않는 랜덤 값 n개
    public static Set<Integer> getRandomUniqueDatas(int limit) {
        Set<Integer> result = new LinkedHashSet<>();

        // 랜덤하게 데이터를 넣는다
		while (result.size() < limit) {
			int random = (int) ((Math.random() * limit) + 1);			
			result.add(random);
		}

        return result;
    }

    public static List<Integer> getRandomDatas() {
        List<Integer> result = new ArrayList<>();
        // 랜덤하게 데이터를 넣는다
		for(int i=0; i<100; i++) {
			
			// 1 ~ 100 까지 랜덤한 수 생성
			int random = (int) ((Math.random() * 100) + 1);			
			result.add(random);
		}

        return result;
    }

    public static List<Integer> getRandomDatas(int limit) {
        List<Integer> result = new ArrayList<>();
        // 랜덤하게 데이터를 넣는다
		for(int i=0; i<limit; i++) {
			
			// 1 ~ 100 까지 랜덤한 수 생성
			int random = (int) ((Math.random() * limit) + 1);			
			result.add(random);
		}

        return result;
    }

    public static void printList(Set<Integer> data) {
        System.out.print("[");
        data.forEach((e) -> {
            System.out.print(e.toString() + ", ");
        });
        System.out.println("]");

    }

    public static void printList(List<Integer> data) {
        System.out.print("[");
        data.forEach((e) -> {
            System.out.print(e.toString() + ", ");
        });
        System.out.println("]");

    }
    
}
