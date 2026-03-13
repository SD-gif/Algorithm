package baekjoon.implement;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_26575 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        double pupsNum = 0;
        double perPrice = 0.0;
        double perAmount = 0.0;
        double finalPrice = 0.0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            pupsNum = Double.parseDouble(st.nextToken());
            perPrice = Double.parseDouble(st.nextToken());
            perAmount = Double.parseDouble(st.nextToken());

            double value = pupsNum * perPrice * perAmount;

            String str = String.format("%.2f", value);
            bw.write("$" + str + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
