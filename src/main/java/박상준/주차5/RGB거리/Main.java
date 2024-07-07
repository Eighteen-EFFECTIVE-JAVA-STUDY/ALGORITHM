package 박상준.주차5.RGB거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * packageName    : 박상준.주차5
 * fileName       : Main
 * author         : ipeac
 * date           : 24. 6. 30.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 30.        ipeac       최초 생성
 */
public class Main {
    private static int[][] RGB;
    private static int[][] DP;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // N 개의 줄에서 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다.
        
        // N 번 집은 N -1 집의 색과 같지 않아야함
        
        // i 번 집의 색은  i-1 번 i+1 번과 같지 않아야함
        RGB = new int[N][3];
        DP = new int[N][3];
        
        for (int i = 0; i < N; i++) {
            RGB[i] = Arrays.stream(br.readLine().split(" "))
                             .mapToInt(Integer::parseInt)
                             .toArray();
        }
        
        DP[0][0] = RGB[0][0];
        DP[0][1] = RGB[0][1];
        DP[0][2] = RGB[0][2];
        
        for (int i = 1; i < N; i++) {
            DP[i][0] = Math.min(DP[i - 1][1], DP[i - 1][2]) + RGB[i][0];
            DP[i][1] = Math.min(DP[i - 1][0], DP[i - 1][2]) + RGB[i][1];
            DP[i][2] = Math.min(DP[i - 1][0], DP[i - 1][1]) + RGB[i][2];
        }
        
        System.out.println(Arrays.stream(DP[N-1]).min().getAsInt());
    }
}