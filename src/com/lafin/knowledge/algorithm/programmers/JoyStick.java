package com.lafin.knowledge.algorithm.programmers;

import java.util.ArrayList;

class JoyStick {
    public int solution(String name) {
        int answer = 0;
        
        // 완료된 문자열 인덱스
        ArrayList<Integer> done = new ArrayList<Integer>();
        
        // 받은 문자열을 char 배열로 분해
        char[] targetName = name.toCharArray();
        
        // 기준점 시작
        int start = Character.getNumericValue('A');
        
        // 기준점 끝
        int end = Character.getNumericValue('Z');
    
        // 가운데 값보다 1 크게 설정 N 보다 커야 Z부터 시작할수있다
        int center = (int)(end - start) / 2 + 1;

        // 커서의 방향을 정한다

        // 왼쪽 거리
        int leftDistance = 0;
        for(int i=targetName.length - 1; i>0; i--){
            if(targetName[i] == 'A') leftDistance++;
            else break;
        }

        // 오른쪽 가리
        int rightDistance = 0;
        for(int i=0; i<targetName.length - 1; i++){
            if(targetName[i+1] == 'A') rightDistance++;
            else break;
        }
        
        // 커서는 A-Z까지 숫자로 치면 65 ~ 90
        int current = 0;
        boolean direction = leftDistance >= rightDistance;
        boolean running = true;
        while(running){
            
            // 현재 커서가 이미 완료된 것이면 통과
            if(!done.contains(current)){
                // 초기 기준값
                int standard = start;

                // 현재 위치의 문자의 값
                int target = Character.getNumericValue(targetName[current]);

                // 가운데 값보다 큰지 작은지 여부
                if(target - standard > center){
                    // 가운데보다 크면 이전알파벳 한번 이동하여 Z부터 시작
                    standard = end;
                    answer++;
                }

                // 기준값과 현재 알파벳의 차이가 이동한 값이 됨
                answer += Math.abs(standard - target);

                // 위 과정을 거치면 무조건 그 문자열은 완료가 된다.
                done.add(current);
            }
            
            // 다음 커서
            int nextCursor = current == targetName.length - 1 ? 0 : current + 1;
            
            // 이전 커서
            int prevCursor = current == 0 ? targetName.length - 1 : current - 1;
            
            // 다음이나 이전커서 둘 중 하나라도 완료되지 않은경우
            if(!done.contains(nextCursor) || !done.contains(prevCursor)){

                // 다음 커서
                current = direction ? nextCursor : prevCursor;

                // 커서를 이동하므로 이동횟수 증가
                answer++;
            }else{
                // 둘 다 완료된 경우 모두 완료 된 것으로 반복문 종료
                running = false;
            }
        }
        
        return answer;
    }


    public static void main(String[] args) {
        JoyStick js = new JoyStick();

        System.out.println(js.solution("JEROEN"));
        System.out.println(js.solution("JAN"));
        System.out.println(js.solution("AAAZDA"));
    }
}