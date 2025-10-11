package 최도혁.주차12.BOJ_15663;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] numbers;
    static boolean[] visited;
    static List<Integer> current;
    static Set<String> resultSet;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        visited = new boolean[N];
        current = new ArrayList<>();
        resultSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        checkPermutation(0);

        bw.flush();
        bw.close();
    }

    static void checkPermutation(int depth) throws IOException {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int num : current) {
                sb.append(num).append(" ");
            }
            String result = sb.toString().trim();
            if (!resultSet.contains(result)) {
                resultSet.add(result);
                bw.write(result + "\n");
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(numbers[i]);

                checkPermutation(depth + 1);

                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }
}

