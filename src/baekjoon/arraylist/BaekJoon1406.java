package baekjoon.arraylist;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class BaekJoon1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Character> list = new LinkedList<>();
        int index = 0;

        String str = br.readLine();
        int n =  Integer.parseInt(br.readLine());

        for ( int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
            index++;
        }

        ListIterator<Character> listIterator = list.listIterator(index);

        StringTokenizer st;

        for ( int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            str = st.nextToken();

            if (str.equals("L")){
                if (listIterator.hasPrevious()) {
                    listIterator.previous();
                }
            }
            else if (str.equals("D")){
                if (listIterator.hasNext()) {
                    listIterator.next();
                }
            }

            else if (str.equals("B")) {
                if (listIterator.hasPrevious()) {
                    listIterator.previous();
                    listIterator.remove();
                }
            }
            else if (str.equals("P")) {
                str = st.nextToken();
                listIterator.add(str.charAt(0));
            }
        }

        for ( Character c : list) {
            bw.write(c);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
