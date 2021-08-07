package com.lafin.knowledge.algorithm.baekjoon.ordinarybackpack;

import java.util.*;

/**
 * 이 문제는 아주 평범한 배낭에 관한 문제이다.
 * 한 달 후면 국가의 부름을 받게 되는 준서는 여행을 가려고 한다. 세상과의 단절을 슬퍼하며 최대한 즐기기 위한 여행이기 때문에, 가지고 다닐 배낭 또한 최대한 가치 있게 싸려고 한다.
 * 준서가 여행에 필요하다고 생각하는 N개의 물건이 있다. 각 물건은 무게 W와 가치 V를 가지는데,
 * 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다. 아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다.
 * 준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.
 *
 * 첫 줄에 물품의 수 N(1 ≤ N ≤ 100)과 준서가 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)가 주어진다.
 * 두 번째 줄부터 N개의 줄에 거쳐 각 물건의 무게 W(1 ≤ W ≤ 100,000)와 해당 물건의 가치 V(0 ≤ V ≤ 1,000)가 주어진다.
 * 입력으로 주어지는 모든 수는 정수이다.
 *
 * @link https://www.acmicpc.net/problem/12865
 * @author lafin
 */
public class Main {

    static int stuffCount;

    static int limitWeight;

	static int valueTable[][];
    
    static int weights[];

    static int values[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		stuffCount = sc.nextInt();
		limitWeight = sc.nextInt();
		
		valueTable = new int[stuffCount + 1][limitWeight + 1];
		
		weights =new int[stuffCount + 1];
		values = new int[stuffCount + 1];
		
		for (int i = 1; i <= stuffCount; i++) {			
			weights[i] = sc.nextInt();
			values[i]= sc.nextInt();
		}
		
		
		for (int i = 1; i <= stuffCount; i++) {
			for (int j = 1; j <= limitWeight; j++) {
                // 이전 아이템의 가치를 저장한다.
				valueTable[i][j] = valueTable[i-1][j]; 

                // 무게에서 자신의 무게를 뺐을 때 남는 무게가 존재하면
                if (j - weights[i] >= 0) { 
                    // 이전 아이템에서 구한 가치와 남은 무게의 가치 + 자신의 가치 중 큰 값을 취한다.
					valueTable[i][j] = Math.max(valueTable[i-1][j], valueTable[i-1][j-weights[i]]+values[i]); 
				}
			}
		}
		
		System.out.println(valueTable[stuffCount][limitWeight]);
    }
}
