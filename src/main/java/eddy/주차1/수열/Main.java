package eddy.주차1.수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String[] temperature = br.readLine().split(" ");
        br.close();


        int days = Integer.parseInt(input[0]);
        int seq = Integer.parseInt(input[1]);


        int[] temperatureArray = new int[temperature.length];
        for (int i = 0; i < days; i++) {
            temperatureArray[i] = Integer.parseInt(temperature[i]);
        }

        Integer highest = null;
        for (int i = 0; i <= days-1; i++) {
            int compare;
            int[] arr = new int[seq];
            for (int j = 0; j<=seq-1 && i+j<days; j++) {
                arr[j] = temperatureArray[i + j];

            }


            int sum = Arrays.stream(arr).sum();
            compare = sum;

            if (highest == null){
                highest = compare;
                continue;
            }
            if (highest < compare){
                highest = compare;
            }

        }
        System.out.println(highest);

    }
}
