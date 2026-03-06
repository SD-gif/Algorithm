package baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon13300 {
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
        String[] a = new String[1];

        a[0] = null;

        System.out.println(a[0]);
        System.out.println(count);
    }
}
