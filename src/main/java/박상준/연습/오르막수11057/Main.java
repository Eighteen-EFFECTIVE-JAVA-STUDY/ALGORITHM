package 박상준.연습.오르막수11057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 오르막수 - 수의 자리가 오름차순으로 이루어진 수
        // 예시 : 2234, 11119
        // 예시 : 3332, 3333 은 오르막수가 아니다.

        // 오르막수의 개수를 10007로 나눈 나머지를 출력

        int N = Integer.parseInt(br.readLine());

        // 길이가 i 이고 마지막 숫자가 j 인 오르막 수
        int[][] dp = new int[N + 1][10];

        // 길이가 1인 오르막 수는 0~9까지의 숫자
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            // 길이가 i이고 마지막 숫자가 0인 오르막 수는 항상 1개 (00...0)
            dp[i][0] = 1;
            for (int j = 1; j < 10; j++) {
                // 이전 단계의 값들을 더할 때 모듈러 연산 적용
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
            }
        }

        System.out.println(Arrays.deepToString(dp));

        int result = 0;
        for (int i = 0; i < 10; i++) {
            // 결과 합산 시에도 모듈러 연산 적용
            result = (result + dp[N][i]) % 10007;
        }

        // 최종 결과는 이미 모듈러 연산이 적용되었으므로 그대로 출력
        System.out.println(result);
    }
}
