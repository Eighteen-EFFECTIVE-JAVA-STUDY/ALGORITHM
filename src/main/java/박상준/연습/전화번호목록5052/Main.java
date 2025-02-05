package 박상준.연습.전화번호목록5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 5052번

문제
전화번호 목록이 주어진다.
이때, 이 목록이 일관성이 있는지 없는지를 구하는 프로그램을 작성하시오.
전화번호 목록이 일관성을 유지하려면, 한 번호가 다른 번호의 접두어인 경우가 없어야 한다.
예를 들어, 전화번호 목록이 아래와 같은 경우를 생각해보자

긴급전화: 911
상근: 97 625 999
선영: 91 12 54 26
이 경우에 선영이에게 전화를 걸 수 있는 방법이 없다.
전화기를 들고 선영이 번호의 처음 세 자리를 누르는 순간 바로 긴급전화가 걸리기 때문이다. 따라서, 이 목록은 일관성이 없는 목록이다.

입력
첫째 줄에 테스트 케이스의 개수 t가 주어진다.
(1 ≤ t ≤ 50) 각 테스트 케이스의 첫째 줄에는 전화번호의 수 n이 주어진다.
(1 ≤ n ≤ 10000) 다음 n개의 줄에는 목록에 포함되어 있는 전화번호가 하나씩 주어진다.
전화번호의 길이는 길어야 10자리이며, 목록에 있는 두 전화번호가 같은 경우는 없다.

출력
각 테스트 케이스에 대해서, 일관성 있는 목록인 경우에는 YES, 아닌 경우에는 NO를 출력한다.

예제 입력 1
2
3
911
97625999
91125426
5
113
12340
123440
12345
98346
예제 출력 1
NO
YES
*/
public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int t = Integer.parseInt(br.readLine());
            final StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < t; i++) {
                //t 첫 째 줄 전화번호 수 n
                boolean isConsecutive = true;
                int n = Integer.parseInt(br.readLine());
                
                String[] phoneNumbers = new String[n];
                // 전화 번호 n 개  받기
                for (int j = 0; j < n; j++) {
                    phoneNumbers[j] = br.readLine();
                }
                
                Arrays.sort(phoneNumbers);
                
                for (int k = 0; k < n - 1; k++) {
                    if (phoneNumbers[k + 1].startsWith(phoneNumbers[k])) {
                        isConsecutive = false;
                        break;
                    }
                }
                
                sb.append(isConsecutive ? "YES" : "NO");
                sb.append("\n");
            }
            
            System.out.println(sb);
        }
    }
}
