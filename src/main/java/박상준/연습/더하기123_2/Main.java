package 박상준.연습.더하기123_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static int N, K;
    static int[] dp;
    static ArrayList<Integer> resultPath = null; // 찾은 경로를 저장할 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // dp 배열 초기화 (N은 최대 11이므로, dp 크기는 N+1 또는 12 정도로 충분)
        // 문제에서 n은 양수이며 11보다 작다고 했으므로, dp[11]까지 필요.
        // dp[0]은 합이 0이 되는 경우의 수로, 1로 설정 (재귀의 기저 사례에서 사용)
        dp = new int[Math.max(N + 1, 4)]; // 최소 크기 4 보장 (dp[0]~dp[3] 접근)

        dp[0] = 1; // 합이 0이 되는 경우는 1가지 (아무것도 선택 안 함)
        dp[1] = 1; // 1
        dp[2] = 2; // 1+1, 2
        dp[3] = 4; // 1+1+1, 1+2, 2+1, 3

        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        // 총 경우의 수가 K보다 작으면 -1 출력
        if (K > dp[N]) {
            System.out.println(-1);
            return;
        }

        findKth(0, K, new ArrayList<>());

        if (resultPath != null) {
            System.out.println(
                resultPath.stream()
                          .map(String::valueOf)
                          .collect(Collectors.joining("+"))
            );
        } else {
             // 이 경우는 K > dp[N] 에서 이미 걸러졌어야 하지만, 안전장치로 둠.
             // 또는 findKth가 아무것도 못찾았을 경우(로직상 발생하면 안됨)
            System.out.println(-1);
        }
    }

    // currentSum: 현재까지 만든 합
    // remainingK: 찾아야 하는 상대적인 k번째 순서
    // currentPath: 현재까지 선택된 숫자들의 경로
    static void findKth(int currentSum, int remainingK, ArrayList<Integer> currentPath) {
        // 이미 결과를 찾았으면 더 이상 진행하지 않음
        if (resultPath != null) {
            return;
        }

        // 기저 사례: 현재 합이 N과 같아지면
        if (currentSum == N) {
            // 정확히 k번째를 찾았을 때만 경로 저장
            // (remainingK가 1이 아니라면, 이 경로는 k번째가 아님.
            //  하지만, 이 함수는 k번째 경로를 따라오도록 설계되었으므로
            //  currentSum == N에 도달했을 때가 k번째임)
            resultPath = new ArrayList<>(currentPath);
            return;
        }
        
        // 현재 합이 N을 초과하면 잘못된 경로이므로 탐색 중단
        if (currentSum > N) {
            return;
        }


        // 다음 숫자로 1을 선택하는 경우
        if (N - (currentSum + 1) >= 0) { // 합이 N을 넘지 않도록
            int countForOne = dp[N - (currentSum + 1)];
            if (remainingK <= countForOne) {
                currentPath.add(1);
                findKth(currentSum + 1, remainingK, currentPath);
                // 찾았으면 여기서 더 이상 다른 경우(2, 3 추가)를 볼 필요 없음
                // 그러나 재귀에서 돌아온 후 path에서 마지막 요소를 제거해야 할 수도 있으므로
                // 여기서는 path.remove를 하지 않고, 이미 찾았으면 resultPath != null 조건으로 빠르게 종료
                if (resultPath != null) return; // 경로 찾았으면 바로 리턴
                currentPath.remove(currentPath.size() - 1); // 백트래킹: 다음 경우의 수를 위해 마지막 추가된 1 제거
            } else {
                remainingK -= countForOne;
            }
        }
        
        // 이미 경로를 찾았다면 더 이상 진행할 필요 없음
        if (resultPath != null) return;

        // 다음 숫자로 2를 선택하는 경우
        if (N - (currentSum + 2) >= 0) {
            int countForTwo = dp[N - (currentSum + 2)];
            if (remainingK <= countForTwo) {
                currentPath.add(2);
                findKth(currentSum + 2, remainingK, currentPath);
                if (resultPath != null) return;
                currentPath.remove(currentPath.size() - 1);
            } else {
                remainingK -= countForTwo;
            }
        }
        
        if (resultPath != null) return;

        // 다음 숫자로 3을 선택하는 경우
        if (N - (currentSum + 3) >= 0) {
            int countForThree = dp[N - (currentSum + 3)];
            // 이 시점에서는 remainingK가 countForThree보다 작거나 같아야 함
            // (위에서 1, 2로 시작하는 경우를 모두 제외했기 때문)
            if (remainingK <= countForThree) { // 안전장치로 조건 확인
                currentPath.add(3);
                findKth(currentSum + 3, remainingK, currentPath);
                if (resultPath != null) return;
                currentPath.remove(currentPath.size() - 1);
            }
            // 여기서 else (remainingK -= countForThree)는 필요 없음.
            // 3을 선택하는 경우가 마지막 시도이기 때문.
        }
    }
}
