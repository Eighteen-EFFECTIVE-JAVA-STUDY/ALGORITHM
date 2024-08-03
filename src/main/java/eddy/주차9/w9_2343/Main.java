package eddy.주차9.w9_2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 입력 받기
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 강의 수
        int M = Integer.parseInt(input[1]); // 블루레이 수

        // 강의 길이 입력 받기
        int[] lessons = new int[N];
        input = br.readLine().split(" ");
        int max = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            lessons[i] = Integer.parseInt(input[i]);
            if (lessons[i] > max) max = lessons[i];
            sum += lessons[i];
        }

        int left = max;
        int right = sum;
        int result = sum;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(lessons, M, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean isPossible(int[] lessons, int M, int size) {
        int count = 1;
        int sum = 0;

        for (int lesson : lessons) {
            if (sum + lesson > size) {
                count++;
                sum = lesson;
                if (count > M) return false;
            } else {
                sum += lesson;
            }
        }

        return true;
    }
}