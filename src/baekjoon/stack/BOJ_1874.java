package baekjoon.stack;

import java.io.*;
import java.util.Stack;

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int count = 1;
        Stack<Integer> stack = new Stack<>();
        boolean isPossible = true;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            while(count <= num) {
                stack.push(count++);
                sb.append("+\n");
            }

            if(stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            }
            else if(stack.peek() > num){
                isPossible = false;
                break;
            }
        }

        if(!isPossible) {
            sb.delete(0, sb.length());
            sb.append("NO");
        }
        System.out.println(sb);
    }
}
