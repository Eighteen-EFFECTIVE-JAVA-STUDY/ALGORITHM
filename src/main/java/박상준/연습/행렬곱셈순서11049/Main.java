package 박상준.연습.행렬곱셈순서11049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * packageName    : 박상준.연습.행렬곱셈순서11049
 * fileName       : Main
 * author         : Jun
 * date           : 25. 3. 3.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 3. 3.        Jun       최초 생성
 */
public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 행렬의 개수
            final int n = Integer.parseInt(br.readLine());
            
            int[][] maxtrics = new int[n + 1][2];
            
            for (int i = 0; i < n; i++) {
                int[] ints = new int[2];
                
                String[] split = br.readLine().split(" ");
                ints[0] = Integer.parseInt(split[0]);
                ints[1] = Integer.parseInt(split[1]);
                
                maxtrics[i] = ints;
            }
            
            long[][] dp = new long[n][n];
            
            // 부분 행렬의 길이 1 ~ n - 1 까지
            for (int length = 2; length <= n; length++) {
                // 시작 지점
                for (int start = 0; start <= n - length; start++) {
                    System.out.println("start = " + start);
                    
                    // 종료 지점
                    int end = start + length - 1;
                    System.out.println("end = " + end);
                    
                    // 최솟값 탐색을 위해 dp 초기값 높게 설정
                    dp[start][end] = Long.MAX_VALUE;
                    
                    for (int k = start; k <= end; k++) {
                        // 구간 분할  k 기준으로 왼쪽 오른쪽 합을 계산한다.
                        long cost = dp[start][k] + dp[k + 1][end] + ((long) maxtrics[start][0] * maxtrics[k][1] * maxtrics[end][1]);
                        dp[start][end] = Math.min(cost, dp[start][end]);
                    }
                }
                
                System.out.println("============================");
            }
            
            System.out.println(dp[0][n - 1]);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
