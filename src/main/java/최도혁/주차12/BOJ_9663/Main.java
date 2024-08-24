package 최도혁.주차12.BOJ_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static int[] queenPositions;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        queenPositions = new int[N];
        count = 0;

        dfs(0);

        System.out.println(count);
    }

    private static void dfs(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                queenPositions[row] = col;
                dfs(row + 1);
            }
        }
    }

    private static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queenPositions[i] == col ||
                    queenPositions[i] - i == col - row ||
                    queenPositions[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }
}
