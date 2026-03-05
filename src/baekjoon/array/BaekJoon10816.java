package baekjoon.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 10816 - 숫자 카드 2
// 문제: N개의 숫자 카드를 가지고 있을 때, M개의 숫자 각각이 몇 개 있는지 출력
// 숫자 범위: -10,000,000 ~ 10,000,000
//
// 풀이 전략: 카운팅 배열 (빈도 배열)
//   - 이분 탐색 대신, 숫자 범위만큼의 배열을 만들어 등장 횟수를 저장
//   - 음수 인덱스를 처리하기 위해 offset(10,000,000)을 더해 양수 인덱스로 변환
//   - ex) 숫자 -5 → 인덱스 9,999,995 / 숫자 0 → 인덱스 10,000,000 / 숫자 5 → 인덱스 10,000,005
//   - 조회 시 O(1)이므로 전체 시간복잡도: O(N + M)
public class BaekJoon10816 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 범위 -10,000,000 ~ 10,000,000 → 총 20,000,001개의 슬롯
        // 각 인덱스에 해당 숫자가 몇 번 등장했는지 저장
        int[] numCheck = new int[20000001];

        // 숫자 카드 N개 입력
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            // offset(10,000,000)을 더해 음수도 양수 인덱스로 매핑 후 카운트 증가
            numCheck[10000000 + Integer.parseInt(st.nextToken())]++;
        }

        // 찾을 숫자 M개 입력
        int m = Integer.parseInt(br.readLine());
        int[] res = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            // 카운팅 배열에서 해당 숫자의 등장 횟수를 O(1)로 조회
            res[i] = numCheck[10000000 + Integer.parseInt(st.nextToken())];
        }

        // 결과 출력
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
