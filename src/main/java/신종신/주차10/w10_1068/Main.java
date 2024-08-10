package 신종신.주차10.w10_1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] tree;
    static boolean[] check;
    static int count = 0;
    static int delete = 0;

    public static void DFS(int idx){
        int cnt = 0;
        if(check[idx]) return;

        for(int x : tree[idx]){
            if(!check[x]){
                DFS(x);
                cnt++;
            }
        }

        if(!check[idx] && cnt==0){
            count++;
        }
    }

    public static void deleteNode(int idx){
        check[idx] = true;
        for(int x : tree[idx]){
            if(!check[x]){
                deleteNode(x);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n];
        check = new boolean[n];
        int root = 0;

        for(int i = 0; i < n; i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(st.nextToken());
            if(x == -1) root = i;
            else{
                tree[x].add(i);
            }
        }

        delete = Integer.parseInt(br.readLine());
        deleteNode(delete);
        DFS(root);
        System.out.println(count);
    }
}
