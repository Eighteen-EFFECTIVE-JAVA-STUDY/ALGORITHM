package 박상준.연습.백준.좋다1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
3
0 0 0

8
* */

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // N 개의 수 중에 특정 값이 다른 수 2개의 합으로 나타낼 수 있따면 해당 수를 "좋다" 라고 한다.
            int N = Integer.parseInt(br.readLine());
            
            int[] arr = new int[N];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            //투포인터 정렬 필수
            Arrays.sort(arr);
            
            int answer = 0;
            
            // 첫번쨰 숫자부터 순회한다.
            for (int currentIndex = 0; currentIndex < N; currentIndex++) {
                int currentNumber = arr[currentIndex];
                // 본인 인덱스보다 낮은 친구들로만 순회해야함.
                int leftIndex = 0;
                int rightIndex = N - 1;
                
                while (true) {
                    if (leftIndex == currentIndex) {
                        leftIndex++;
                    } else if (rightIndex == currentIndex) {
                        rightIndex--;
                    }
                    
                    //불가능한 조건
                    if (leftIndex >= rightIndex) {
                        break;
                    }
                    
                    long sum = arr[leftIndex] + arr[rightIndex];
                    
                    if (sum == currentNumber) {
                        answer++;
                        break;
                    } else if (sum < currentNumber) {
                        leftIndex++;
                    } else {
                        rightIndex--;
                    }
                }
            }
            
            System.out.println(answer);
        }
    }
}
