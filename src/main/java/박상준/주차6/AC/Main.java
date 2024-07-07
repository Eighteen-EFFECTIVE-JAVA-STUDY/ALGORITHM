package 박상준.주차6.AC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * packageName    : 박상준.주차6.AC
 * fileName       : Main
 * author         : ipeac
 * date           : 24. 7. 7.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 7. 7.        ipeac       최초 생성
 */
public class Main {
    private static final String ERROR = "error";
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder answer = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            char[] functions = br.readLine().toCharArray();
            
            int qSize = Integer.parseInt(br.readLine());
            
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            
            Deque<Integer> queue = new ArrayDeque<>();
            
            while (st.hasMoreTokens()) {
                String inputData = st.nextToken();
                
                queue.add(Integer.parseInt(inputData));
            }
            
            boolean isError = false;
            boolean isReverse = false;
            
            for (char function : functions) {
                if (checkIfReverse(function)) {
                    isReverse = !isReverse;
                    continue;
                }
                
                if (checkIfDiscardFirst(function)) {
                    if (queue.isEmpty()) {
                        isError = isError(answer);
                        break;
                    }
                    
                    if (isReverse) queue.pollLast();
                    else queue.pollFirst();
                    
                    qSize--;
                }
            }
            
            if (isError) {
                continue;
            }
            
            if (isReverse && !queue.isEmpty()) {
                queue = reversed(qSize, queue);
            }
            
            answer.append(format(queue)).append("\n");
        }
        
        System.out.println(answer);
    }
    
    private static boolean isError(StringBuilder answer) {
        answer.append(ERROR).append("\n");
        return true;
    }
    
    private static Deque<Integer> reversed(int qSize, Deque<Integer> queue) {
        Deque<Integer> tempQueue = new ArrayDeque<>();
        
        for (int i = 0; i < qSize; i++) {
            tempQueue.addLast(queue.pollLast());
        }
        
        queue = tempQueue;
        return queue;
    }
    
    private static String format(Deque<Integer> tDeque) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("[");
        
        for (int t : tDeque) {
            sb.append(t).append(",");
        }
        
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        sb.append("]");
        
        return sb.toString();
    }
    
    private static boolean checkIfDiscardFirst(char function) {
        return function == 'D';
    }
    
    private static boolean checkIfReverse(char function) {
        return function == 'R';
    }
}