package 최도혁.주차2.수정렬하기2;

import java.io.*;
import java.util.TreeSet;

public class BOJ_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        TreeSet<String> treeSet = new TreeSet<>();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            treeSet.add(String.valueOf(num));
        }
        for (String num : treeSet) {
            bw.write(num);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
