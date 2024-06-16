package 박상준.주차3.바닥장식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * packageName    : 박상준.주차3.바닥장식
 * fileName       : Main
 * author         : ipeac
 * date           : 24. 6. 16.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 16.        ipeac       최초 생성
 */
public class Main {
    private static final int[] DX = {0, 0, -1, 1};
    private static final int[] DY = {-1, 1, 0, 0};
    private static int N;
    private static int M;
    
    public static void main(String[] args) throws IOException {
        int answer = 0;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // -- 한 세트(행) | | 한 세트 (열)
        
        // 방 바닥을 장식하는데 필요한 나무 판자의 개수 출력
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 바닥 세로 크기 N
        N = Integer.parseInt(st.nextToken());
        
        // 바닥의 가로 크기 M
        M = Integer.parseInt(st.nextToken());
        
        char[][] floor = new char[N][M];
        
        boolean[][] visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                floor[i][j] = line.charAt(j);
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == false) {
                    bfs(floor, i, j, visited);
                    answer++;
                }
            }
        }
        
        System.out.println(answer);
    }
    
    private static void bfs(char[][] floor, int x, int y, boolean[][] visited) {
        // 1. 방문한 곳은 1로 표시
        visited[x][y] = true;
        
        // 2. 상하좌우로 이동하면서 방문하지 않은 곳을 방문
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int currentX = current.x;
            int currentY = current.y;
            
            char currentType = floor[currentX][currentY];
            
            for (int i = 0; i < 4; i++) {
                int nx = currentX + DX[i];
                int ny = currentY + DY[i];
                
                if (0 > nx || 0 > ny || nx >= N || ny >= M || visited[nx][ny]) {
                    continue;
                }
                
                char nextType = floor[nx][ny];
                
                boolean isSameAsCurrent = (nextType == currentType);
                
                if (isSameAsCurrent && (isHorizon(currentType, i) || isVertical(currentType, i))) {
                    visited[nx][ny] = true;
                    queue.add(new Pair(nx, ny));
                }
            }
        }
    }
    
    private static boolean isHorizon(char currentType, int index) {
        return (currentType == '-') && (index == 0 || index == 1);
    }
    
    private static boolean isVertical(char currentType, int index) {
        return (currentType == '|') && (index == 2 || index == 3);
    }
    
    static class Pair {
        int x;
        int y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}