package com.lafin.knowledge.algorithm.programmers;

import java.util.Arrays;

/**
 * [해시] 전화번호 목록
 * @author lafin
 * 
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 * 
 * 구조대 : 119
 * 박준영 : 97 674 223
 * 지영석 : 11 9552 4421
 * 
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 
 * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한사항
 * - phone_book의 길이는 1 이상 1,000,000 이하입니다.
 *   = 각 전화번호의 길이는 1 이상 20 이하입니다.
 *   = 같은 전화번호가 중복해서 들어있지 않습니다.
 *   
 * 입출력예제
 * phone_book	                        return
 * ["119", "97674223", "1195524421"]	false
 * ["123","456","789"]	                true
 * ["12","123","1235","567","88"]	    false
 *
 */
public class PhoneBook {
	
	
	public boolean solution(String[] phoneBook) {
        boolean answer = true;
        
        Arrays.sort(phoneBook);
        
        for(int i=0; i<phoneBook.length-1; i++){
            if(phoneBook[i+1].startsWith(phoneBook[i])){
                answer = false;
                break;
            }
        }
        
        return answer;
    }
	
	
	public static void main(String[] args) {
		PhoneBook pb = new PhoneBook();
		
		// 테스트 케이스
		String[] phoneBook = {"119", "97674223", "1195524421"};
		
		// 정답
		System.out.println("정답 : " + pb.solution(phoneBook));
	}
}
