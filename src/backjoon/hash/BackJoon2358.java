package backjoon.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BackJoon2358 {
    public static void main(String[] args) {
        // key = 좌표, value = 점의 개수
        Map<Integer, Integer> xCount = new HashMap<>();
        Map<Integer, Integer> yCount = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            // Map.getOrDefault(key, default) = key 값에 해당하는 value를 가져온다. 이 때, 값이 없으면 디폴트 값을 리턴
            xCount.put(x, xCount.getOrDefault(x, 0) + 1);
            yCount.put(y, yCount.getOrDefault(y, 0) + 1);
        }

        int result = 0;

        for(int i : xCount.values()){
            // 벨류 값이 2 이상 이다 == 키(좌표) 값에 해당 하는 점이 2개 이상이다.
            // 점이 2개 이상이면 직선이 만들어짐.
            if(i >= 2) result++;
        }

        for(int i : yCount.values()){
            if(i >= 2) result++;
        }

        System.out.println(result);
    }
}
