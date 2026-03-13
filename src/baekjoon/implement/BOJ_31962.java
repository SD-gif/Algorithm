package baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_31962 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int maxTime = Integer.parseInt(st.nextToken());
        int count = 0;
        int maxStart = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (start + end <= maxTime && start > maxStart) {
                maxStart = start;
                count++;
            }
        }

        if(count == 0) System.out.println(-1);
        else System.out.println(maxStart);

    }
}
