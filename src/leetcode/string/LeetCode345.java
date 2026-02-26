package leetcode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 345 - Reverse Vowels of a String
 *
 * [문제 유형]
 * - 투 포인터 (Two Pointers)
 * - 문자열 조작
 *
 * [풀이 방식]
 * left, right 두 포인터를 양 끝에서 시작해 안쪽으로 좁혀가며 탐색한다.
 * - left가 모음이 아니면 left를 오른쪽으로 이동
 * - right가 모음이 아니면 right를 왼쪽으로 이동
 * - 양쪽 모두 모음이면 교환 후 두 포인터를 동시에 이동
 * else if 구조를 사용해 한 번의 반복에서 불필요한 중복 호출을 방지한다.
 *
 * [모음 조회 최적화]
 * String.indexOf() 대신 HashSet을 사용해 O(1) 조회로 개선한다.
 * static final로 선언해 매 호출마다 재생성하지 않는다.
 *
 * [시간/공간 복잡도]
 * - 시간: O(n) - 배열을 한 번 순회
 * - 공간: O(1) - 입력 배열을 직접 수정 (in-place), HashSet 크기는 고정 10
 */
public class LeetCode345 {

    private static final Set<Character> VOWELS =
            new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (!VOWELS.contains(arr[left])) {
                left++;
            } else if (!VOWELS.contains(arr[right])) {
                right--;
            } else {
                char tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        }

        return new String(arr);
    }

    /*
     * [기존 코드]
     *
     * public String reverseVowels(String s) {
     *     char[] arr = s.toCharArray();
     *     int left = 0;
     *     int right = arr.length - 1;
     *
     *     while (left < right) {
     *         if(!vowelCheck(arr[left])) left++;
     *         if(!vowelCheck(arr[right])) right--;
     *
     *         if(vowelCheck(arr[left]) && vowelCheck(arr[right])){
     *             char tmp = arr[left];
     *             arr[left] = arr[right];
     *             arr[right] = tmp;
     *             left++;
     *             right--;
     *         }
     *     }
     *
     *     return new String(arr);
     * }
     *
     * public boolean vowelCheck(char c){
     *     return ("aeiouAEIOU".indexOf(c) >= 0);
     * }
     */
}