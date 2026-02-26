package leetcode.string;

/**
 * LeetCode 151 - Reverse Words in a String
 *
 * [문제 유형]
 * - 투 포인터 (Two Pointers)
 * - 문자열 조작
 *
 * [풀이 방식]
 * right 포인터를 문자열 끝에서 시작해 왼쪽으로 이동하며 단어를 추출한다.
 * 1. right로 후행 공백을 건너뜀
 * 2. left로 단어의 시작점을 탐색
 * 3. s.substring(left+1, right+1)로 단어 추출 후 StringBuilder에 추가
 * 4. right = left - 1로 다음 탐색 시작점 이동
 *
 * [기존 코드가 가독성이 복잡한 이유]
 * - left, right 두 포인터를 동시에 관리하면서 각 상태 조합(공백/비공백)에 따라
 *   else if 분기가 3개로 나뉘어 흐름을 파악하기 어렵다.
 * - spaceCheck() 메서드를 매 분기마다 반복 호출해 조건식이 길어진다.
 * - left == 0 경계 조건을 첫 번째 분기 안에 별도로 처리해야 하는 특수 케이스가 존재한다.
 * - 포인터가 이동하는 시점이 각 분기마다 달라 추적이 어렵다.
 *
 * [리팩토링 코드와의 차이점]
 * - 포인터를 right 하나로 단순화하고, 내부 while로 공백/단어를 명확히 분리해 탐색한다.
 * - spaceCheck() 없이 s.charAt() == ' ' 인라인 비교로 메서드 호출 오버헤드를 제거한다.
 * - left == 0 경계 조건을 별도 처리할 필요 없이 left + 1, right + 1로 자연스럽게 처리된다.
 * - 각 단계(공백 건너뜀 → 단어 탐색 → 추출)가 순서대로 명확히 분리되어 있다.
 *
 * [시간/공간 복잡도]
 * - 시간: O(n) - 문자열을 한 번 순회
 * - 공간: O(n) - 결과 StringBuilder
 */
public class LeetCode151 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int right = s.length() - 1;

        while (right >= 0) {
            // 후행 공백 건너뜀
            while (right >= 0 && s.charAt(right) == ' ') right--;
            if (right < 0) break;

            // 단어 시작점 탐색
            int left = right;
            while (left >= 0 && s.charAt(left) != ' ') left--;

            // 단어 추출
            if (!sb.isEmpty()) sb.append(' ');
            sb.append(s, left + 1, right + 1);

            right = left - 1;
        }

        return sb.toString();
    }

    /*
     * [기존 코드]
     *
     * public String reverseWords(String s) {
     *     StringBuilder sb = new StringBuilder();
     *     int left = s.length() - 1, right = s.length() -1;
     *
     *     while (left >= 0) {
     *         if(!spaceCheck(s.charAt(left))){
     *             if(left > 0) left--;
     *             else {
     *                 if(!sb.isEmpty()) sb.append(' ') ;
     *                 sb.append(s, left, right + 1);
     *                 left--;
     *             }
     *         }
     *
     *         else if(spaceCheck(s.charAt(left)) && !spaceCheck(s.charAt(right))){
     *             if(!sb.isEmpty()) sb.append(' ') ;
     *             sb.append(s, left + 1, right + 1);
     *             left--;
     *             right = left;
     *         }
     *
     *         else if(spaceCheck(s.charAt(left)) && spaceCheck(s.charAt(right))){
     *             left--;
     *             right = left;
     *         }
     *     }
     *
     *     return sb.toString();
     * }
     *
     * public static boolean spaceCheck(char c){
     *     return (c == ' ');
     * }
     */
}