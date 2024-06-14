package 박상준.주차1.수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * packageName    : 박상준.주차1.수열
 * fileName       : Main
 * author         : ipeac
 * date           : 24. 5. 31.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 5. 31.        ipeac       최초 생성
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        //온도 측정 전체 날짜의 수
        int N = Integer.parseInt(input[0]);
        // 연속적인 K 일의 온도
        int K = Integer.parseInt(input[1]);

        //1. K 합을 구하기 위한 연속적인 날짜
        String[] seqStr = br.readLine().split(" ");
        int[] sequences = new int[N + 1];

        for (int i = 0; i < N; i++) {
            int seqNum = Integer.parseInt(seqStr[i]);
            sequences[i] = seqNum;
        }

        //2. 연속 온도 구하기
        //첫번째 연속 날짜 숫자 더하기
        int maxTemp = 0;

        for (int i = 0; i < K; i++) {
            maxTemp += sequences[i];
        }

        //두번째 날부터 슬라이딩윈도우로 첫번째값 제거 새로 추가될 값 추가
        int windowSum = maxTemp;

        for (int i = K; i < N; i++) {
            windowSum += sequences[i] - sequences[i - K];

            if (windowSum > maxTemp) {
                maxTemp = windowSum;
            }
        }

        System.out.println(maxTemp);
    }
}