package 박상준.연습.포도주시음31589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 포도주의 수 N ; 산들이의 주량 K
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        
        // N 개의 포도주의 T 주어짐.
        List<Integer> winesTastes = new ArrayList<>();

        // 와인 맛 세팅하기
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(br.readLine());
            winesTastes.add(t);
        }
        
        winesTastes.sort(Comparator.reverseOrder());
        
        // 초기값은 무조건 큰값으로 선택한다
        int first = winesTastes.get(0);
        
        for (int i = 0; i < K - 1; i++) {
          // 뒤에서부터 덧셈을 수행한다.
            int
        }
    }
}
