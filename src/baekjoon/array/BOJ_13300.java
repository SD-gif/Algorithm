package baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 13300 - 방 배정
// 문제 유형: 구현 / 배열
//
// 문제 요약:
//   - N명의 학생을 성별(0: 여, 1: 남), 학년(1~6)별로 같은 방에 배정
//   - 한 방에 최대 K명까지 수용 가능
//   - 성별과 학년이 다른 학생은 같은 방을 쓸 수 없음
//   - 필요한 방의 최소 개수 출력
//
// 알고리즘 분석:
//   1. 2차원 배열 students[성별(2)][학년(6)]로 그룹별 학생 수 집계
//   2. 각 그룹의 방 수 = ceil(학생 수 / K) = (학생 수 + K - 1) / K
//      - 나누어 떨어지면 그대로, 나머지가 있으면 +1 (올림 나눗셈)
//   3. 모든 그룹의 방 수를 합산
//
// 시간복잡도: O(N) — 학생 수만큼 입력 + 12개 그룹 순회
// 공간복잡도: O(1) — 고정 크기 배열(2×6) 사용
public class BOJ_13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] students = new int[2][6];
        int gender, grade;
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numS = Integer.parseInt(st.nextToken());
        int maxS = Integer.parseInt(st.nextToken());

        for( int i = 0; i < numS; i++ ) {
            st = new StringTokenizer(br.readLine());
            gender = Integer.parseInt(st.nextToken());
            grade = Integer.parseInt(st.nextToken());
            students[gender][grade - 1]++;
        }

        for( int i = 0; i < 2; i++ ) {
            for ( int j = 0; j < 6; j++ ) {
                if( students[i][j] > 0) {
                    if( students[i][j] % maxS == 0 ) count += ((students[i][j] / maxS));
                    else count += (((students[i][j] / maxS)) + 1);
                }
            }
        }

        System.out.println(count);
    }
}
