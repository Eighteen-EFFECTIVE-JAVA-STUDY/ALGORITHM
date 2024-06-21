package eddy.주차3.w03_1388;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * packageName    : eddy.주차1.9996
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
    static int N, M;
    static char[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j]) {
                    continue;
                }if(arr[i][j] == '-') {
                    dfs(i, j, true);
                }else {
                    dfs(i, j, false);
                }
                cnt++;
            }
        }

        System.out.println(cnt);

    }
    private static void dfs(int i, int j, boolean row) {
        visited[i][j] = true;
        if(row) {
            j++;
            if(j<M && arr[i][j] == '-') dfs(i, j, true);
        }
        else {
            i++;
            if(i<N && arr[i][j] != '-') dfs(i, j, false);
        }

    }

}

