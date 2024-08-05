package 최도혁.주차10.BOJ_1058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] friendsMatrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            friendsMatrix[i] = br.readLine().toCharArray();
        }

        int maxFriends = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            boolean[] visited = new boolean[n];

            for (int j = 0; j < n; j++) {
                if (i != j && (friendsMatrix[i][j] == 'Y' || isFriendOfFriend(i, j, friendsMatrix))) {
                    visited[j] = true;
                }
            }

            for (boolean b : visited) {
                if (b) count++;
            }

            maxFriends = Math.max(maxFriends, count);
        }

        System.out.println(maxFriends);
    }

    private static boolean isFriendOfFriend(int i, int j, char[][] friendsMatrix) {
        for (int k = 0; k < friendsMatrix.length; k++) {
            if (k != i && k != j && friendsMatrix[i][k] == 'Y' && friendsMatrix[k][j] == 'Y') {
                return true;
            }
        }
        return false;
    }
}
