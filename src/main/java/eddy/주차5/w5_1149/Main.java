package eddy.주차5.w5_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  //집의 개수
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            int[] arrInt = new int[3];
            String[] temp = br.readLine().split(" ");

            for (int j = 0; j < 3; j++) {
                arrInt[j] = Integer.parseInt(temp[j]);
            }
            arr[i] = arrInt;

        }


        for (int i = 1; i < n; i++) {
            //재귀함수
            arr[i][0] = arr[i][0] + Math.min(arr[i-1][1], arr[i-1][2]); //red
            arr[i][1] = arr[i][1] + Math.min(arr[i-1][0], arr[i-1][2]); //green
            arr[i][2] = arr[i][2] + Math.min(arr[i-1][0], arr[i-1][1]); //blue

        }
        //세 개의 값 중에서 최소값 출력
        System.out.println(Math.min(arr[n-1][0], Math.min(arr[n-1][1], arr[n-1][2])));
    }
}



