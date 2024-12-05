package 박상준.구름에듀.카드찾기;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    
    public static final int IS_CONTAINED = 1;
    public static final int IS_NOT_CONTAINED = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //자연수 N
        int N = Integer.parseInt(br.readLine());
        
        //카드에 적힌 숫자
        Set<Integer> cards = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            cards.add(Integer.parseInt(st.nextToken()));
        }
        
        //확인하고 싶은 숫자 M
        int M = Integer.parseInt(br.readLine());
        
        if(cards.contains(M)) {
            System.out.println(IS_CONTAINED);
        } else {
            System.out.println(IS_NOT_CONTAINED);
        }
    }
}
