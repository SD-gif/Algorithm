package leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int max = 0;

        // 1단계: 현재 사탕 수의 최댓값 탐색
        for (int candy : candies) {
            if (candy > max) {
                max = candy;
            }
        }

        // 2단계: 각 아이에게 extraCandies를 전부 줬을 때 최댓값 이상인지 확인
        for (int candy : candies) {
            // [개선] if/else 제거: 비교 연산의 결과가 이미 boolean이므로 바로 add() 가능
            // 변경 전: if (candy + extraCandies >= max) { ans.add(true); } else ans.add(false);
            ans.add(candy + extraCandies >= max);
        }
        return ans;
    }
}
