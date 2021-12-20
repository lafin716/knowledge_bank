package com.lafin.knowledge.algorithm.programmers.kakao;

import java.util.*;
import java.util.stream.Collector;

/**
 * 레스토랑을 운영하던 스카피는 코로나19로 인한 불경기를 극복하고자 메뉴를 새로 구성하려고 고민하고 있습니다.
    기존에는 단품으로만 제공하던 메뉴를 조합해서 코스요리 형태로 재구성해서 새로운 메뉴를 제공하기로 결정했습니다. 어떤 단품메뉴들을 조합해서 코스요리 메뉴로 구성하면 좋을 지 고민하던 "스카피"는 이전에 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성하기로 했습니다.
    단, 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성하려고 합니다. 또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함하기로 했습니다.

    예를 들어, 손님 6명이 주문한 단품메뉴들의 조합이 다음과 같다면,
    (각 손님은 단품메뉴를 2개 이상 주문해야 하며, 각 단품메뉴는 A ~ Z의 알파벳 대문자로 표기합니다.)

    손님 번호	주문한 단품메뉴 조합
    1번 손님	A, B, C, F, G
    2번 손님	A, C
    3번 손님	C, D, E
    4번 손님	A, C, D, E
    5번 손님	B, C, F, G
    6번 손님	A, C, D, E, H
    가장 많이 함께 주문된 단품메뉴 조합에 따라 "스카피"가 만들게 될 코스요리 메뉴 구성 후보는 다음과 같습니다.

    코스 종류	메뉴 구성	설명
    요리 2개 코스	A, C	1번, 2번, 4번, 6번 손님으로부터 총 4번 주문됐습니다.
    요리 3개 코스	C, D, E	3번, 4번, 6번 손님으로부터 총 3번 주문됐습니다.
    요리 4개 코스	B, C, F, G	1번, 5번 손님으로부터 총 2번 주문됐습니다.
    요리 4개 코스	A, C, D, E	4번, 6번 손님으로부터 총 2번 주문됐습니다.
 */
public class MenuRenewal {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        // 각 요리의 주문 횟수 누적값
        Map<String, Integer> menuOrderCount = new HashMap<>();
        for (int i = 0; i < orders.length; i++) {

            // 고객 주문 메뉴 오름차순 정렬
            char[] menus = orders[i].toCharArray();
            Arrays.sort(menus);

            for (char menu : menus) {
                String key = Character.toString(menu);
                menuOrderCount.put(key, menuOrderCount.getOrDefault(key, 0) + 1);
            }

            orders[i] = Arrays.toString(menus);
        }
        
        // 누적값이 2 이상인 메뉴만 배열에 담고 오름차순 정렬
        List<String> availableMenus = new ArrayList<>();
        Iterator<String> menuKeys = menuOrderCount.keySet().iterator();
        while (menuKeys.hasNext()) {
            String key = menuKeys.next().toString();
            if (menuOrderCount.get(key) >= 2) {
                availableMenus.add(key);
            }
        }

        // 리스트를 배열로 변환
        String[] liee = availableMenus.toArray(new String[availableMenus.size()]);
        
        // 메뉴별로 가능한 코스 조합 배열 생성
        List<String> courseList = new ArrayList<>();
        for (int i = 0; i < liee.length; i++) {
            System.out.println(liee[i]);
        }
        
        // 고객이 주문한 코스와 일치하는지 카운트
        
        // 카운트가 2 이상인 코스만 배열 생성

        return answer;
    }

    public static void main(String[] args) {
        MenuRenewal renewal = new MenuRenewal();
        
        String[] result1 = renewal.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
        System.out.println(Arrays.toString(result1));
    }
}
