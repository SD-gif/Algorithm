package baekjoon.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Stack<int[]> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int input = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty()) {
                if (stack.peek()[0] >= input) {
                    bw.write(stack.peek()[1] + " ");
                    break;
                }

                stack.pop();
            }

            if(stack.isEmpty()){
                bw.write("0 ");
            }

            stack.push(new int[]{input, i});
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
