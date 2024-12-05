package 박상준.백준.주차8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * packageName    : 박상준.백준.주차8
 * fileName       : Main
 * author         : ipeac
 * date           : 24. 7. 28.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 7. 28.        ipeac       최초 생성
 */
public class Main {
    
    public static final String EMPTY = "EMPTY";
    
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 이중 우선순위 큐 - 데이터 삭제시 우선순위가 가장 높은 데이터 또는 가장 낮은 데이터 중 하나를 삭제하는 자료구조.
            // 데이터 삭제 연산은 2가지로 구분됨. -> 우선순위 가장 높은 데이터 삭제, 우선순위 가장 낮은 데이터 삭제
            // 정수만 저장하는 이중 우선순위 큐 Q , 각 정수 값 자체는 우선순위로 간주
            // 최종적으로 Q 에 저장된 데이터 중 최댓값과 최솟값을 출력하는 프로그램을 작성하시오.
            
            // T : 테스트 데이터 개수
            // k ; 연산의 개수
            // D 1 : Q 에서 최댓값을 삭제하는 연산.
            // D -1 ; Q 에서 최솟값을 삭제하는 연산.
            // 최댓값(최솟값) 삭제 연산시 최대값(최솟값) 이 둘 이상인 경우, 하나만 삭제됨
            
            // Q 가 비어있는데 적용할 연산 `D` 가 있을 경우, 해당 연산 무시
            
            StringBuilder sb = new StringBuilder();
            
            int T = Integer.parseInt(br.readLine());
            
            while (T-- > 0) {
                TreeMap<Integer, Integer> doublyProirityQueue = new TreeMap<>();
                int k = Integer.parseInt(br.readLine());
                
                for (int i = 0; i < k; i++) {
                    
                    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                    
                    Operation operation = Operation.findBy(st.nextToken());
                    int num = Integer.parseInt(st.nextToken());
                    
                    if (operation.isInsert()) {
                        doublyProirityQueue.put(num, doublyProirityQueue.getOrDefault(num, 0) + 1);
                        continue;
                    }
                    
                    if (operation.isDelete()) {
                        if (doublyProirityQueue.isEmpty()) {
                            continue;
                        }
                        
                        if (isMinValueOf(num)) {
                            int value = doublyProirityQueue.get(doublyProirityQueue.firstKey());
                            // 1 개뿐인 경우 아예 삭제
                            if (value == 1) {
                                doublyProirityQueue.remove(doublyProirityQueue.firstKey());
                                continue;
                            }
                            
                            doublyProirityQueue.put(doublyProirityQueue.firstKey(), value - 1);
                            continue;
                        }
                        
                        if (isMaxValueOf(num)) {
                            int value = doublyProirityQueue.get(doublyProirityQueue.lastKey());
                            // 1개 뿐인 경우 아예 삭제
                            if (value == 1) {
                                doublyProirityQueue.remove(doublyProirityQueue.lastKey());
                                continue;
                            }
                            
                            doublyProirityQueue.put(doublyProirityQueue.lastKey(), value - 1);
                        }
                    }
                }
                
                if (doublyProirityQueue.isEmpty()) {
                    sb.append(EMPTY).append("\n");
                    continue;
                }
                
                sb.append(doublyProirityQueue.lastKey()).append(" ").append(doublyProirityQueue.firstKey()).append("\n");
            }
            
            System.out.println(sb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static boolean isMaxValueOf(int num) {
        return num == 1;
    }
    
    private static boolean isMinValueOf(int num) {
        return num == -1;
    }
    
    public enum Operation {
        INSERT("I"),
        DELETE("D"),
        ;
        
        private final String operation;
        
        Operation(String operation) {
            this.operation = operation;
        }
        
        public String getOperation() {
            return operation;
        }
        
        public boolean isDelete() {
            return this == DELETE;
        }
        
        public boolean isInsert() {
            return this == INSERT;
        }
        
        public static Operation findBy(String operation) {
            for (Operation value : values()) {
                if (value.getOperation().equals(operation)) {
                    return value;
                }
            }
            
            throw new UnsupportedOperationException("해당하는 연산이 없습니다.");
        }
    }
}
