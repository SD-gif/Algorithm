package leetcode.string;

public class LeetCode2645 {
    public int addMinimum(String word) {
        int count = 0;
        char expect = 'a'; // 현재 "abc" 그룹에서 기대하는 문자 (a → b → c → a 순환)

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            // ch가 expect와 다르면 빠진 문자이므로 삽입 횟수를 세고 기대값을 전진
            while(ch != expect) {
                count++;
                expect = next(expect);
            }

            // ch == expect: 현재 문자를 소비하고 다음 기대값으로 이동
            expect = next(expect);
        }

        // 마지막 그룹이 완성되지 않은 경우 남은 문자 수 추가
        if(expect == 'b') count += 2; // 'b', 'c' 모두 빠진 경우
        if(expect == 'c') count += 1; // 'c' 만 빠진 경우
        // expect == 'a': 마지막 그룹이 완성된 경우, 추가 불필요

        return count;
    }

    // 'a' → 'b' → 'c' → 'a' 순환하는 헬퍼 함수
    public char next(char ch) {
        if (ch == 'a') return 'b';
        if (ch == 'b') return 'c';
        return 'a';
    }

}

/* 완전한 문자열이 되기 위해서 "abc" 가 모여야 함. 따라서 다음에 어떤 문자가 와야하는지 기대값을 정하고,
문자를 비교 하여 기대값과 같은 경우 기대값을 다음 문자로 넘기며 문자 소거하고 다음 문자와 기대값을 비교한다.
기대값과 다른 경우 빠진 문자이므로 count를 증가시키고 기대값을 전진하여 현재 문자와 일치할 때까지 반복한다.
루프 종료 후 마지막 그룹의 남은 문자 수(expect 위치 기준)를 count에 추가하여 최솟값을 반환한다. */
