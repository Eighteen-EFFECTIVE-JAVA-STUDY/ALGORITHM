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
    static int N, M;  //가로 세로 크기
    static char[][] arr;
    static boolean[][] visited;  // 위치 방문 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M]; //입력된 패턴을 저장하는 배열
        visited = new boolean[N][M]; //방문여부를 기록하는 배열
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int cnt = 0; // 장식 모양 개수 카운트

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j]) {   //이미 방문했던 위치라면 그냥 지나치기
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
            //다음 문자열이 똑같이 -패턴이면 가로로 계속 탐색
            if(j<M && arr[i][j] == '-') dfs(i, j, true);
        }
        else {
            i++;
            //다음 문자열이 ㅣ 패턴이면 세로로 ㅣ패턴이 끝날 때까지 끝까지 탐색
            if(i<N && arr[i][j] != '-') dfs(i, j, false);
        }

    }

}

