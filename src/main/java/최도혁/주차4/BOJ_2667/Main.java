package 최도혁.주차4.BOJ_2667;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int[][] map = new int[25][25];
    private static final boolean[][] vis = new boolean[25][25];
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    private static final LinkedList<Integer> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        int total_group = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !vis[i][j]) {
                    result.add(bfs(i, j, N));
                    total_group++;
                }
            }
        }

        System.out.println(total_group);
        Collections.sort(result);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    private static int bfs(int x, int y, int N) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        vis[x][y] = true;
        int cnt = 1;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (!vis[nx][ny] && map[nx][ny] == 1) {
                    vis[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                    cnt++;
                }
            }
        }

        return cnt;
    }
}