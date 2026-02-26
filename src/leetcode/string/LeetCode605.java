package leetcode.string;

/**
 * LeetCode 605 - Can Place Flowers
 *
 * [문제 유형]
 * - 그리디 (Greedy)
 * - 배열 순회
 *
 * [그리디 방식 설명]
 * 앞에서부터 순서대로 탐색하며, 꽃을 심을 수 있는 조건을 만족하면 즉시 심는다.
 * 탐욕적으로 최대한 일찍 심는 것이 항상 최적해를 보장한다.
 * 이유: 최대한 앞에 심을수록, 뒤에 심을 공간이 줄어들지 않거나 같기 때문이다.
 *
 * [꽃을 심는 조건]
 * 현재 칸이 비어있고(0), 왼쪽 칸도 비어있고, 오른쪽 칸도 비어있을 때 심는다.
 * - 배열의 경계(첫 번째, 마지막)는 해당 방향의 이웃이 없으므로 비어있는 것으로 간주한다.
 * - 꽃을 심은 후 해당 칸을 1로 마킹하여 이후 순회에서 충돌을 방지한다.
 *
 * [시간/공간 복잡도]
 * - 시간: O(n) - 배열을 한 번 순회
 * - 공간: O(1) - 입력 배열을 직접 수정 (in-place)
 */
public class LeetCode605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            boolean left = (i == 0) || (flowerbed[i - 1] == 0);
            boolean right = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

            if (flowerbed[i] == 0 && left && right) {
                flowerbed[i] = 1;
                count++;
                if (count >= n) return true; // 조기 종료: 충분히 심었으면 바로 반환
            }
        }

        return count >= n;
    }

    /*
     * [기존 코드 - 특수 케이스(길이 1)를 별도 처리]
     *
     * public boolean canPlaceFlowers(int[] flowerbed, int n) {
     *     int count = 0;
     *
     *     if (flowerbed.length == 1){
     *         if (flowerbed[0] == 0){
     *             count++;
     *         }
     *         return count >= n;
     *     }
     *
     *     for (int i = 0; i < flowerbed.length; i++) {
     *
     *         if (i == 0) {
     *             if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
     *                 flowerbed[i] = 1;
     *                 count++;
     *             }
     *         }
     *
     *         else if (i == flowerbed.length - 1) {
     *             if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) count++;
     *         }
     *
     *         else if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
     *             flowerbed[i] = 1;
     *             count++;
     *         }
     *     }
     *
     *     return count >= n;
     * }
     */
}