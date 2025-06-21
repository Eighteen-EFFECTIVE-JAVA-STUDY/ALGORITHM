package 박상준.주차11.N과M9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * packageName    : 박상준.주차11
 * fileName       : Main
 * author         : ipeac
 * date           : 24. 8. 21.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 8. 21.        ipeac       최초 생성
 */
public class Main {
    private static boolean[] visited;
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int[] arr = new int[N];
            
            st = new StringTokenizer(br.readLine(), " ");
            
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(arr);
            
            visited = new boolean[N];
            
            Set<String> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            dfs(arr, new int[M], 0, sb, set);
            
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void dfs(int[] arr, int[] result, int depth, StringBuilder sb, Set<String> uniqueCombinations) {
        if (depth == result.length) {
            StringBuilder temp = new StringBuilder();
            for (int i : result) {
                temp.append(i).append(" ");
            }
            
            String trimed = temp.toString().trim();
            if (!uniqueCombinations.contains(trimed)) {
                uniqueCombinations.add(trimed);
                sb.append(trimed).append("\n");
            }
            
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            
            if (visited[i]) {
                continue;
            }
            
            result[depth] = value;
            visited[i] = true;
            dfs(arr, result, depth + 1, sb, uniqueCombinations);
            visited[i] = false;
        }
    }
}
