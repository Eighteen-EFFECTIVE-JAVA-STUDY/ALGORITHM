package 박상준.주차1.한국이_그리울_땐_서버에_접속하지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * packageName    : 박상준.주차1.한국이_그리울_땐_서버에_접속하지
 * fileName       : Main
 * author         : ipeac
 * date           : 24. 5. 31.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 5. 31.        ipeac       최초 생성
 */
public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            
            StringBuilder sb = new StringBuilder();
            //java.util.Pattern 으로 풀어도 되지만 쉬운 문제는 그렇게 할수있는데 , 조금 어려워지면 그렇게 풀 수 없을 것이라고 생각하여
            // 단순한 방법으로 풀었습니다.
            String[] patterns = br.readLine().split("\\*");
            
            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                
                if(input.length() < patterns[0].length() + patterns[1].length()) {
                    sb.append("NE").append("\n");
                    continue;
                }
                
                if (input.startsWith(patterns[0]) && input.endsWith(patterns[1])) {
                    sb.append("DA").append("\n");
                    continue;
                }
                
                sb.append("NE").append("\n");
            }
            
            System.out.println(sb);
        } catch (Exception ignored) {
        }
    }
}