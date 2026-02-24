package leetcode.string;

/* 두 문자열을 다루는 경우, 두 문자열의 길이가 서로 다를 경우 배열을 사용하게 되면 인덱싱을 다루기 쉽지 않다.
따라서, 이 경우에는 StringBuilder 객체를 사용하면 쉽게 다룰 수 있다.*/

class Leet1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i =0, j = 0;

        while(i < word1.length() && j < word2.length()){
            sb.append(word1.charAt(i++)); // append 메소드는 문자열을 추가하는 경우
            sb.append(word2.charAt(j++));
        }

        /* subString(beginIndex, endIndex) 메소드는 매개변수에 따라 다른 값을 보여준다.
        * 먼저 subString(beginIndex) 인 경우 시작 인덱스 부터 끝까지의 문자열을 잘라낸다.
        * 다음 subString(beginIndex, endIndex) 인 경우 시작 인덱스 부터 끝 인덱스 바로 전 까지의 문자열을 잘라낸다.
        * */

        sb.append(word1.substring(i));
        sb.append(word2.substring(j));

        return sb.toString();
    }
}
