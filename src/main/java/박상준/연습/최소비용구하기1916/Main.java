package 박상준.연습.최소비용구하기1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * packageName    : 박상준.연습.최소비용구하기1916
 * fileName       : Main
 * author         : ipeac
 * date           : 25. 3. 16.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 3. 16.        ipeac       최초 생성
 */
public class Main {
    static class Edge {
        int to, weight;
        
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public String toString() {
            return "Edge{" +
                           "to=" + to +
                           ", weight=" + weight +
                           "}\n";
        }
    }
    
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N 개의 도시가 있음.
        final int N = Integer.parseInt(br.readLine());
        
        // 한도시에서 출발해 다른 도시에 도착하는 M 개의 버스
        final int M = Integer.parseInt(br.readLine());
        
        // A ->B 버스 비용 C(가중치)
        final List<List<Edge>> graph = new ArrayList<>();
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            String[] split = br.readLine().split(" ");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            int weight = Integer.parseInt(split[2]);
            
            graph.get(from).add(new Edge(to, weight));
        }
        
        // M +3 째 줄에는 출발점 도시번호와 도착점 도시번호가 주어짐.
        String[] split = br.readLine().split(" ");
        int start = Integer.parseInt(split[0]);
        int end = Integer.parseInt(split[1]);
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        pq.add(new Edge(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            final Edge currentEdge = pq.poll();
            final int currVertex = currentEdge.to;
            final int currWeight = currentEdge.weight;
            
            if (visited[currVertex]) continue;
            visited[currVertex] = true;
            
            for (Edge edge : graph.get(currVertex)) {
                final int nextVertex = edge.to;
                final int nextWeight = edge.weight;
                
                // 다음 가중치 + 현재 가중치 가 기록된 가중치보다 작으면 갱신
                if (!visited[nextVertex] && nextWeight + currWeight < dist[nextVertex]) {
                    dist[nextVertex] = currWeight + nextWeight;
                    pq.add(new Edge(nextVertex, dist[nextVertex]));
                }
            }
        }
        System.out.println(dist[end] - dist[start]);
    }
}
