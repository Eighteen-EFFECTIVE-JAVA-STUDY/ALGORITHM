package eddy.주차4.w4_2491;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * packageName    : eddy.주차1.9996
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

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        int[] arrInt = new int[n];
        for (int i = 0; i < n; i++) {
            arrInt[i] = Integer.parseInt(arr[i]);
        }

        //길이 카운트
        int count = 1;
        int maxCount = 1;

        for ( int i = 1; i < n; i++) {
            if (arrInt[i - 1] <= arrInt[i]) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 1;
            }

        }

        count = 1;
        for ( int i = 1; i < n; i++) {
            // 길이가 1일경우

            if (arrInt[i - 1] >= arrInt[i]) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 1;
            }
        }

        System.out.println(maxCount);
    }
}
