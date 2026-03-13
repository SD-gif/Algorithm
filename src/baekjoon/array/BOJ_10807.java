package baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        int count = 0;
        int checkNUm = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        checkNUm = Integer.parseInt(br.readLine());

        for(int j = 0; j < num; j++){
            if(arr[j] == checkNUm) count++;
        }

        System.out.println(count);
    }
}
