package 최도혁.주차9.BOJ_7662;

import java.io.*;
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
                StringBuilder commend = new StringBuilder(br.readLine());
                applyCommend(commend);
            }

            if(nums.isEmpty())
                bw.write(EMPTY);
            else
                bw.write(nums.lastKey() + " " + nums.firstKey());
            bw.newLine();
        }
        bw.flush();
    }

    private static void applyCommend(StringBuilder cmd){
        char operation = cmd.charAt(0);
        char checkMinus = cmd.charAt(2);
        int num = Integer.parseInt(String.valueOf(cmd.replace(0,2,"")));

        if(operation == 'I'){
            nums.put(num,(nums.getOrDefault(num,0)+1));

        } else if(!nums.isEmpty()){
            if(checkMinus == '-'){
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

    private static int getCount(int key){
        return nums.get(key);
    }
}