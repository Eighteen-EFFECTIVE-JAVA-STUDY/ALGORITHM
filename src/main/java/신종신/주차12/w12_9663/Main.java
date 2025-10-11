package 신종신.주차12.w12_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, ans = 0;
    static int[] mat;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        mat = new int[N];

        back(0);

        System.out.println(ans);
    }

    static void back(int row){
        if(row == N){
            ans++;
            return;
        }

        for(int i = 0; i < N; i++){
            mat[row] = i;
            if(check(row)){
                back(row+1);
            }
        }
    }

    static boolean check(int row){
        for(int i = 0; i < row; i++){
            if(mat[i] == mat[row] || Math.abs(mat[row] - mat[i]) == row - i) return false;
        }
        return true;
    }
}
