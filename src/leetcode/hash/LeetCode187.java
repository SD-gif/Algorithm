package leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LeetCode187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        // Map.Entry<String, Integer> entry == Map 의 한 요소(= key-value 한 쌍)
        // Map.entrySet() == Set<Map.Entry<K, V>> entrySet()
        // Map에 저장된 key-value 쌍들을 Set 형태로 반환해줌.
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if(value >= 2) res.add(key);
        }

        return res;
    }
}