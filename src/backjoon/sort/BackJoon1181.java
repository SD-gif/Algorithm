package backjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BackJoon1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 중복되는 문자열의 입력을 제거 하기 위해 Set 사용
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        // 문자열을 비교하기 위해 리스트 형태로 변경
        List<String> list = new ArrayList<>(set);
        // 먼저, 길이 순으로 정렬하고, 길이가 같다면 사전 순으로 정렬
        list.sort((s1, s2) -> {
            if(s1.length() != s2.length()) return s1.length() - s2.length();
            return s1.compareTo(s2);
        });

        for(String s : list) {
            System.out.println(s);
        }
    }
}
