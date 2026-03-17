package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch(str) {
                case "push" :
                    q.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    if(!q.isEmpty()) sb.append(q.removeFirst()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "size" :
                    sb.append(q.size()).append("\n");
                    break;
                case "empty" :
                    if(!q.isEmpty()) sb.append(0).append("\n");
                    else sb.append(1).append("\n");
                    break;
                case "front" :
                    if(!q.isEmpty()) sb.append(q.getFirst()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "back" :
                    if(!q.isEmpty()) sb.append(q.getLast()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
