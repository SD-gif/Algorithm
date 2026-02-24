package leetcode.string;

public class LeetCode1071 {
    public String gcdOfStrings(String str1, String str2) {
        // 두 문자열을 순서를 바꿔 합친 결과가 다른 경우, 최대공약수를 만족하지 않음
        if(!(str1+str2).equals((str2+str1))) return "";

        // 최대공약수 만큼의 문자열을 출력
        int gcdval = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdval);
    }

    // 유클리드 호제법 반복문 버전
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}

