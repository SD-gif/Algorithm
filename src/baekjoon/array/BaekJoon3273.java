package baekjoon.array;

/**
 * 백준 3273 - 두 수의 합
 * https://www.acmicpc.net/problem/3273
 *
 * [문제 유형] 배열 + 해시(카운팅 배열)
 *
 * [알고리즘] 카운팅 배열을 해시셋처럼 활용한 Two Sum
 *   - checkNum[v] = 1 로 숫자 v의 존재 여부를 O(1)에 조회
 *   - i + (x - i) = x 이므로, 0~x-1 범위를 순회하며 두 수가 모두 존재하면 count++
 *   - 쌍 (a, b)는 i=a일 때와 i=b일 때 각각 1번씩 총 2번 카운트되므로 최종적으로 count/2
 *
 * [시간 복잡도] O(n + x)  - 입력 처리 O(n), 쌍 탐색 O(x)
 * [공간 복잡도] O(1)       - checkNum 크기가 고정(2,000,001)
 */

import java.util.Scanner;

public class BaekJoon3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 값의 존재 여부를 O(1)로 조회하기 위한 카운팅 배열 (값 범위: 1 ~ 1,000,000)
        int[] checkNum = new int[2000001];

        int n = sc.nextInt();
        int[] arr = new int[n];
        int count = 0;

        // 배열 입력
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 각 숫자의 존재 여부를 checkNum에 마킹 (해시셋 역할)
        for(int i = 0; i < n; i++){
            checkNum[arr[i]] = 1;
        }

        int x = sc.nextInt();

        // i + (x - i) = x 를 만족하는 쌍 탐색
        // 각 쌍은 (a, b), (b, a) 두 번 카운트되므로 마지막에 /2
        for(int i = 0; i < x; i++) {
            if(checkNum[i] == 1 && checkNum[x - i] == 1) count++;
        }

        System.out.println(count / 2);
    }
}

