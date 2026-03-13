package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int top = 0;

        int k = 0;

        for (int i = 0; i < n; i++) {
            k =  Integer.parseInt(br.readLine());
            if( k > 0 ) arr[top++] = k;
            else top--;
        }

        for (int i = 0; i < top; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
    }
}
