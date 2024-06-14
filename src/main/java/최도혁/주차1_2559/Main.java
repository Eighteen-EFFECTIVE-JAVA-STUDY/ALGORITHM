package 최도혁.주차1_2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * packageName    : eddy.주차1
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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();

        int max = -987654321;
        int sum = 0;
        st = new StringTokenizer(br.readLine(), " ");
        while (n-- > 0) {
            int temp = Integer.parseInt(st.nextToken());

            if (queue.size() == k) {
                max = Math.max(max, sum);
                sum -= queue.poll();
            }
            queue.add(temp);
            sum += temp;
        }
        if(queue.size() == k){
            max = Math.max(max, sum);
        }
        System.out.print(max);
    }
}