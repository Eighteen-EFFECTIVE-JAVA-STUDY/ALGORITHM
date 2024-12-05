package 박상준.백준.주차8.문자열폭발;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Stack;

/**
 * packageName    : 박상준.백준.주차8.문자열폭발
 * fileName       : Main
 * author         : ipeac
 * date           : 24. 7. 24.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 7. 24.        ipeac       최초 생성
 */
public class Main {
    private static final String EMPTY_ANSWER = "FRULA";
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = br.readLine().split("");
            String[] bombs = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            
            for (String ch : split) {
                stack.push(ch);
                
                if (stack.size() < bombs.length) {
                    continue;
                }
                
                boolean isBomb = true;
                for (int i = 0; i < bombs.length; i++) {
                    // stack peek 부터 차례차례 비교한다.
                    if (!Objects.equals(stack.get(stack.size() - 1 - i), bombs[bombs.length - 1 - i])) {
                        isBomb = false;
                        break;
                    }
                }
                
                if (isBomb) {
                    for (int i = 0; i < bombs.length; i++) {
                        stack.pop();
                    }
                }
            }
            
            if (stack.isEmpty()) {
                System.out.println(EMPTY_ANSWER);
                return;
            }
            
            StringBuilder sb = new StringBuilder();
            for (String s : stack) {
                sb.append(s);
            }
            
            System.out.println(sb);
        } catch (Exception e) {
        }
    }
}
