package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon3986 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());

        for(int i = 0; i < inputNum; i++) {
            String str = br.readLine();
            char[] stack = new char[str.length()];
            int top = -1;

            for(int j = 0; j < str.length(); j++) {
                if(top == -1 || str.charAt(j) != stack[top]) {
                    top++;
                    stack[top] = str.charAt(j);
                }

                else if(stack[top] == str.charAt(j)){
                    top--;
                }

            }
            if (top == -1) count++;
        }

        System.out.println(count);
    }
}