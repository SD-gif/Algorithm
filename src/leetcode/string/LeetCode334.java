package leetcode.string;

/**
 * LeetCode 334. Increasing Triplet Subsequence
 *
 * [문제 유형]
 * - 배열(Array) / 탐욕법(Greedy)
 * - i < j < k 이고 nums[i] < nums[j] < nums[k] 인 인덱스 삼중쌍의 존재 여부 반환
 *
 * [풀이 방식 - 탐욕 투 변수(Greedy Two Variables)]
 * - first  : 지금까지 본 원소 중 가장 작은 값
 * - second : first 이후에 등장한 원소 중 first보다 큰 최솟값
 * - 순회 중 first도 second도 아닌 더 큰 값이 나오면 → 삼중 증가 수열 존재 → true 반환
 *
 * [알고리즘 선택 이유]
 * - DP로 풀면 O(n²), 이진 탐색 기반 LIS로 풀면 O(n log n)
 * - 삼중 수열(길이 3)만 확인하면 되므로, 두 변수만으로 O(n) / O(1) 풀이 가능
 * - 전체 증가 수열 길이를 구할 필요 없을 때 가장 효율적인 선택
 *
 * [언제 써야 하는가]
 * - "길이 k의 증가 부분 수열이 존재하는가?"에서 k가 고정된 소수(2·3 등)일 때
 * - O(n) 시간, O(1) 공간 제약이 주어진 경우
 * - 정확한 인덱스나 수열 자체가 아닌, 존재 여부(boolean)만 필요할 때
 *
 * [시간 복잡도] O(n)
 * [공간 복잡도] O(1)
 */
public class LeetCode334 {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int num : nums){
            if (num <= first) {
                first = num;
            }
            else if (num <= second) {
                second = num;
            }
            else return true;
        }

        return false;
    }
}
