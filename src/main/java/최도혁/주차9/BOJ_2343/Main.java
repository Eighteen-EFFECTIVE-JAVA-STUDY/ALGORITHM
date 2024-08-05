package 최도혁.주차9.BOJ_2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] lectures;
    private static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        lectures = new int[N];

        int sum = 0;
        int maxBlueray = 0;
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            sum += lectures[i];
            if (maxBlueray < lectures[i])
                maxBlueray = lectures[i];
        }
        System.out.println(binarySearch(maxBlueray, sum));
    }

    private static int binarySearch(int start, int end) {
        while (start < end){
            int mid = (start + end) / 2;
            if (countLectures(mid) <= M)
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }

    private static int countLectures(int mid) {
        int cnt = 1;
        int remain = mid;
        for (int i = 0; i < N; i++) {
            if (remain < lectures[i]) {
                remain = mid;
                cnt++;
            }
            remain -= lectures[i];
        }
        return cnt;
    }
}
