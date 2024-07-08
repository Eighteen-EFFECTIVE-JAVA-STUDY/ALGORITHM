package 최도혁.주차6.BOJ_5430;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            String cmd = br.readLine();
            int arrLength = Integer.parseInt(br.readLine());

            String[] arr = convert(br.readLine());

            if(count_cmd_D(cmd) > arrLength){
                bw.write("error");
                bw.newLine();
                continue;
            }

            int start = 0, end = arrLength-1;
            boolean reverseType = false;
            int cmdLength = cmd.length();
            for(int i=0; i<cmdLength; i++){
                if(cmd.charAt(i) == 'R'){
                    reverseType = !reverseType;
                } else if(cmd.charAt(i) == 'D'){
                    if(reverseType){ end--; }
                    else { start++; }
                }
            }

            bw.write(print_arr(arr,start,end,reverseType));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    // 명령어에서 D의 개수를 찾는 메서드
    private static int count_cmd_D(String cmd){
        int cnt_D = 0;
        int len = cmd.length();
        char cur;

        for(int i=0; i<len; i++){
            cur = cmd.charAt(i);
            if(cur == 'D'){ cnt_D++; }
        }
        return cnt_D;
    }

    // 배열입력 값에서 대괄호와 쉼표 제거하는 메서드
    private static String[] convert(String arr){
        char cur;
        int len = arr.length();
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<len-1; i++){
            cur = arr.charAt(i);
            sb.append(cur);
        }
        return sb.toString().split(",");
    }

    // 결과값에 대괄호와 쉼표 추가 및 배열 방향 정하는 메서드
    private static String print_arr(String[] arr, int start, int end, boolean reverseType){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(reverseType){
            for(int i=end; i>=start; i--){
                sb.append(arr[i]);
                if(i != start)
                    sb.append(",");
            }
        } else {
            for(int i=start; i<=end; i++){
                sb.append(arr[i]);
                if(i != end)
                    sb.append(",");
            }
        }

        sb.append("]");

        return sb.toString();
    }
}
