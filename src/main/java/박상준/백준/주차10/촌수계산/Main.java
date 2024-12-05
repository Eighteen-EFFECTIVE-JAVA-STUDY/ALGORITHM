package 박상준.백준.주차10.촌수계산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * packageName    : 박상준.백준.주차10.촌수계산
 * fileName       : Main
 * author         : ipeac
 * date           : 24. 8. 13.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 8. 13.        ipeac       최초 생성
 */
public class Main {
    static List<Integer>[] GRAPH;
    static int TOTAL_PERSON_COUNT;
    
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            TOTAL_PERSON_COUNT = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int targetPerson1 = Integer.parseInt(st.nextToken());
            int targetPerson2 = Integer.parseInt(st.nextToken());
            
            int N = Integer.parseInt(br.readLine());
            
            GRAPH = new ArrayList[TOTAL_PERSON_COUNT + 1];
            for (int i = 1; i <= TOTAL_PERSON_COUNT; i++) {
                GRAPH[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                
                int person1 = Integer.parseInt(st.nextToken());
                int person2 = Integer.parseInt(st.nextToken());
                
                // 양방향 관계
                GRAPH[person1].add(person2);
                GRAPH[person2].add(person1);
            }
            
            bfs(targetPerson1, targetPerson2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void bfs(int start, int target) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[TOTAL_PERSON_COUNT + 1];
        
        queue.offer(new int[]{start, 0});
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int count = current[1];
            
            if (node == target) {
                System.out.println(count);
                return;
            }
            
            for (int next : GRAPH[node]) {
                if (!visited[next]) {
                    queue.offer(new int[]{next, count + 1});
                    visited[next] = true;
                }
            }
        }
        
        System.out.println(-1);
    }
}
