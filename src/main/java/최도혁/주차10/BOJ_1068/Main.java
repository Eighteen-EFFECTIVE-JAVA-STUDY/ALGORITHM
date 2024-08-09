package 최도혁.주차10.BOJ_1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final Map<Integer, List<Integer>> tree = new HashMap<>();
    private static int cnt = 0;
    private static int root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] parents = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(parents[i]);

            if (parent == -1) {
                root = i;  // 루트 노드 설정
                continue;
            }

            tree.putIfAbsent(parent, new ArrayList<>());
            tree.get(parent).add(i);
        }

        int delIndex = Integer.parseInt(br.readLine());

        deleteNode(delIndex);

        // 루트가 삭제되지 않은 경우에만 리프 노드 계산
        if (delIndex != root) {
            countLeafNodes(root);
        }

        System.out.print(cnt);
    }

    private static void countLeafNodes(int node) {
        if (!tree.containsKey(node) || tree.get(node).isEmpty()) {
            cnt++;
            return;
        }

        for (int child : tree.get(node)) {
            countLeafNodes(child);
        }
    }

    private static void deleteNode(int node) {
        // 노드를 삭제하기 위해 큐 사용 (BFS 방식)
        Queue<Integer> toDelete = new LinkedList<>();
        toDelete.add(node);

        while (!toDelete.isEmpty()) {
            int current = toDelete.poll();

            // 현재 노드에 자식이 있으면, 삭제할 노드 큐에 추가
            if (tree.containsKey(current)) {
                toDelete.addAll(tree.get(current));
                tree.remove(current);  // 현재 노드를 트리에서 제거
            }
        }

        // 부모 노드에서 삭제된 노드에 대한 참조 제거
        for (int parent : tree.keySet()) {
            tree.get(parent).remove(Integer.valueOf(node));
        }
    }
}