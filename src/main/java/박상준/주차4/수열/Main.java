package 박상준.주차4.수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * packageName    : 박상준.주차4.수열
 * fileName       : Main
 * author         : ipeac
 * date           : 24. 6. 22.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 22.        ipeac       최초 생성
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        List<Integer> arr = new ArrayList<>();
        
        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        while (st.hasMoreTokens()) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        
        if (N == 1) {
            System.out.println(1);
            return;
        }
        
        int upCount = 1;
        int downCount = 1;
        
        int maxLen = 1;
        
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) >= arr.get(i - 1)) {
                upCount++;
            } else {
                upCount = 1;
            }
            
            if (arr.get(i - 1) >= arr.get(i)) {
                downCount++;
            } else {
                downCount = 1;
            }
            
            maxLen = Math.max(Math.max(upCount, downCount), maxLen);
        }
        
        System.out.println(maxLen);
    }
}