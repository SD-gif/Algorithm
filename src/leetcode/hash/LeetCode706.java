package leetcode.hash;

import java.util.Arrays;

class LeetCode706 {
    int[] maps;

    public LeetCode706() {
        maps = new int[1000001];
        Arrays.fill(maps, -1);
    }

    public void put(int key, int value) {
        maps[key] = value;
    }

    public int get(int key) {
        return maps[key];
    }

    public void remove(int key) {
        maps[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */