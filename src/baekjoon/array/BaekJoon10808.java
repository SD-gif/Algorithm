package baekjoon.array;

public class BaekJoon10808 {

    int[] insert(int idx, int num, int[] arr, int len){
        int[] resArr = new int[len + 1];

        for (int i = 0; i < idx; i++) {
            resArr[i] = arr[i];
        }

        resArr[idx] = num;

        for (int i = idx + 1; i <= len; i++) {
            resArr[i] = arr[i - 1];
        }

        return resArr;
    }

    int[] erase(int idx, int[] arr, int len){
        int[] resArr = new int[len - 1];

        for (int i = 0; i < idx; i++) {
            resArr[i] = arr[i];
        }
        for (int i = idx; i < len - 1; i++) {
            resArr[i] = arr[i + 1];
        }

        return resArr;
    }
}
