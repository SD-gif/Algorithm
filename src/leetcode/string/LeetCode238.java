package leetcode.string;

/**
 * LeetCode 238. Product of Array Except Self
 *
 * [문제 유형]
 * - 배열(Array) / 접두사·접미사 곱(Prefix & Suffix Product)
 *
 * [알고리즘]
 * - 결과 배열을 두 번 순회하여 각 원소의 왼쪽/오른쪽 누적 곱을 계산
 *   1) 왼쪽 → 오른쪽: res[i] = i 기준 왼쪽 모든 원소의 곱 (Prefix Product)
 *   2) 오른쪽 → 왼쪽: right 변수로 오른쪽 누적 곱을 유지하며 res[i]에 반영 (Suffix Product)
 *
 * [시간 복잡도] O(n) — 두 번의 선형 순회
 * [공간 복잡도] O(1) — 결과 배열(res) 외 추가 공간 미사용
 *
 * [이 방법을 사용하는 경우]
 * - 나눗셈을 사용하지 않고 자기 자신을 제외한 곱을 구해야 할 때
 * - 배열에 0이 포함되어 나눗셈으로 풀 수 없는 경우
 * - O(n) 시간, O(1) 공간 제약이 동시에 주어진 경우
 * - 구간 누적 곱, 구간 누적 합 등 "양쪽 방향 누적값"이 필요한 문제 전반
 */
public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;

        for(int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int right = 1;

        for(int i = n - 1; i >= 0; i--){
            res[i] *= right;
            right *= nums[i];
        }

        return res;
    }
}
