package 최도혁.주차9.BOJ_7662;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    private static final String EMPTY = "EMPTY";

    private static TreeMap<Integer,Integer> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            nums = new TreeMap<>();
            int K = Integer.parseInt(br.readLine());

            for (int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                String operation = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                applyCommend(operation,num);
            }

            if(nums.isEmpty())
                bw.write(EMPTY);
            else
                bw.write(nums.lastKey() + " " + nums.firstKey());
            bw.newLine();
        }
        bw.flush();
    }

    private static void applyCommend(String operation, int num){

        if(isInsert(operation)){
            nums.put(num,(nums.getOrDefault(num,0)+1));

        } else if(!nums.isEmpty()){
            if(isMinus(num)){
                int key = nums.firstKey();

                if(getCount(key) > 1)
                    nums.put(key,nums.get(key)-1);
                else
                    nums.pollFirstEntry();
            }

            else {
                int key = nums.lastKey();

                if(getCount(key) > 1)
                    nums.put(key,nums.get(key)-1);
                else
                    nums.pollLastEntry();
            }
        }
    }

    private static boolean isInsert(String operation){
        return operation.equals("I");
    }

    private static boolean isMinus(int num){
        return num < 0;
    }

    private static int getCount(int key){
        return nums.get(key);
    }
}