package 박상준.주차6.등수매기기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * packageName    : 박상준.주차6.등수매기기
 * fileName       : Main
 * author         : ipeac
 * date           : 24. 7. 7.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 7. 7.        ipeac       최초 생성
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long answer = 0;
        
        int N = Integer.parseInt(br.readLine());
        
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        
        Collections.sort(arr);
        
        int rank = 1;
        
        for (int expected : arr) {
            answer += Math.abs(rank - expected);
            rank++;
        }
        
        System.out.println(answer);
    }
}