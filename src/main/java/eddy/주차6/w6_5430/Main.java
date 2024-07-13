package eddy.주차6.w6_5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        //읽어오기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[][] arr = new String[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = br.readLine();
            arr[i][1] = br.readLine();
            arr[i][2] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(algorithm(arr[i]));
        }
    }

    // 함수
    static String algorithm(String[] arr) {
        char[] charArr = arr[0].toCharArray();
        int arrLen = Integer.parseInt(arr[1]);
        int[] intArr = new int[arrLen];
        String temp = "";

        String[] test = arr[2].toString().replace("[", "").replace("]", "").split((","));

        for (int i = 0; i < arrLen; i++) {
            intArr[i] = Integer.parseInt(test[i]);
        }

        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == 'R') {
                intArr = rev(intArr);
                temp = Arrays.toString(intArr);
            }
            if (charArr[i] == 'D') {
                if (intArr.length == 0) {
                    temp = "ERROR";
//                    System.out.println("ERROR");
                    break;
                } else {
                    intArr = del(intArr);
                    temp = Arrays.toString(intArr);
                }
            }
        }
        return temp;
    }


    //2. R(뒤집기) 함수 만들기 = 배열의 수의 순서 뒤집기
    static int[] rev(int[] a) {
        int[] b = new int[a.length];
        int temp = a[0];
        for (int i = 0; i < a.length - 1; i++) {
            b[i] = a[a.length - 1 - i];
        }
        b[a.length - 1] = temp;
        return b;
    }

    //3. D(버리기) 함수 만들기  = 첫번쨰 수 버리기
    static int[] del(int[] a) {
        int[] b = Arrays.copyOfRange(a, 1, a.length);
        return b;
    }
}