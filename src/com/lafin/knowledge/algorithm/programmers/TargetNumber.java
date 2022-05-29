package com.lafin.knowledge.algorithm.programmers;

public class TargetNumber {

    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }

    public void dfs(int[] numbers, int depth, int target, int sum) {
        if (depth == numbers.length) {
            if (target == sum) {
                answer++;
            }
            return;
        }

        dfs(numbers, depth + 1, target, sum + numbers[depth]);
        dfs(numbers, depth + 1, target, sum - numbers[depth]);
    }

    public static void main(String[] args) {
        TargetNumber targetNumber = new TargetNumber();

        System.out.print("expect : 5, result : ");
        System.out.println(targetNumber.solution(new int[]{1,1,1,1,1}, 3));
        System.out.print("expect : 2, result : ");
        System.out.println(targetNumber.solution(new int[]{4,1,2,1}, 4));
    }
}
