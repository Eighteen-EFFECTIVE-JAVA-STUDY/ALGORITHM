package 박상준.백준.주차7.후위표기식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * packageName    : 박상준.백준.주차7.후위표기식
 * fileName       : Main
 * author         : ipeac
 * date           : 24. 7. 14.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 7. 14.        ipeac       최초 생성
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder answer = new StringBuilder();
        
        Deque<Character> queue = new ArrayDeque<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine(), "*+-/()", true);
        
        while (st.hasMoreTokens()) {
            char inputChar = st.nextToken().charAt(0);
            
            // 연산자인 경우
            if (Operator.checkOperator(inputChar)) {
                if (inputChar == '(') {
                    queue.offer('(');
                    continue;
                }
                
                if (inputChar == ')') {
                    while (!queue.isEmpty() && queue.peekLast() != '(') {
                        answer.append(queue.pollLast());
                    }
                    
                    queue.pollLast();
                    continue;
                }
                
                
                // 연산자가 등장하는 경우 - 다음 연산자가 더 낮은 우선순위를 가지는 경우나 같은 경우
                while (!queue.isEmpty() && queue.peekLast() != '(' && queue.peekLast() != ')' && Operator.findOperator(queue.peekLast()).isPriorityHigherOrEqualsThan(Operator.findOperator(inputChar))) {
                    answer.append(queue.pollLast());
                }
                
                queue.offer(inputChar);
                continue;
            }
            
            // 일반 피연산자인 경우
            answer.append(inputChar);
        }
        
        // 남은 출력
        while (!queue.isEmpty()) {
            answer.append(queue.pollLast());
        }
        
        System.out.println(answer);
    }
    
    enum Operator {
        LEFT_BRACKET(2, '('),
        RIGHT_BRACKET(2, ')'),
        PLUS(1, '+'),
        MINUS(1, '-'),
        MULTIPLY(0, '*'),
        DIVIDE(0, '/');
        
        private final int priority;
        private final char operator;
        
        Operator(int priority, char operator) {
            this.priority = priority;
            this.operator = operator;
        }
        
        public boolean isPriorityHigherOrEqualsThan(Operator other) {
            return this.priority <= other.priority;
        }
        
        public static boolean checkOperator(char value) {
            for (Operator operator : values()) {
                if (operator.operator == value) {
                    return true;
                }
            }
            
            return false;
        }
        
        public static Operator findOperator(char operator) {
            for (Operator value : values()) {
                if (value.operator == operator) {
                    return value;
                }
            }
            
            throw new UnsupportedOperationException("지원하지 않는 연산자입니다.");
        }
    }
}
