package 박상준.백준.주차8.기타레슨;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * packageName    : 박상준.백준.주차8.기타레슨
 * fileName       : Main
 * author         : ipeac
 * date           : 24. 7. 29.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 7. 29.        ipeac       최초 생성
 */
public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            int sum = 0;
            int max = 0;
            
            st = new StringTokenizer(br.readLine(), " ");
            
            int[] lesson = new int[n];
            
            for (int i = 0; i < n; i++) {
                int input = Integer.parseInt(st.nextToken());
                
                max = Math.max(max, input);
                sum += input;
                lesson[i] = input;
            }
            
            int start = max;
            int end = sum;
            
            start = binarySearch(start, end, n, lesson, m);
            
            System.out.println(start);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static int binarySearch(int start, int end, int n, int[] lesson, int m) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int count = countBlurays(n, lesson, mid);
            
            if (count <= m) {
                end = mid - 1;
                continue;
            }
            
            start = mid + 1;
        }
        return start;
    }
    
    private static int countBlurays(int n, int[] lesson, int size) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + lesson[i] > size) {
                count++;
                sum = lesson[i];
                continue;
            }
            
            sum += lesson[i];
        }
        return count;
    }
}
