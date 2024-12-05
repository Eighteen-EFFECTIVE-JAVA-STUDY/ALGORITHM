package 박상준.백준.주차9.친구;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * packageName    : 박상준.백준.주차9.친구
 * fileName       : Main
 * author         : ipeac
 * date           : 24. 8. 5.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 8. 5.        ipeac       최초 생성
 */
public class Main {
    // 직접 친구인 경우 1로 설정
    public static final int DIRECT_FRIEND_VALUE = 1;
    
    // 본인이랑 이어진 경우 0으로 설정
    public static final int INDIRECT_FRIEND_VALUE = 0;
    
    // 거리값의 최대가 10,000 이 나오지 않기에 10,000 으로 설정함
    public static final int MOCKED_INF_VALUE = 10000;
    
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 1. 2차원 배열 받기
            int N = Integer.parseInt(br.readLine());
            int[][] friends = new int[N][N];
            
            // 친구 관계를 그래프로,, 각 친구는 정점이며, 관계는 간선으로 표현한다..
            // 직접 친구인 경우 1 , 아닌 경우 0, 친구가 아닌 경우 10,000 으로 설정한다.
            for (int i = 0; i < N; i++) {
                String[] st = br.readLine().split("");
                
                for (int j = 0; j < N; j++) {
                    if (isMe(i, j)) {
                        friends[i][j] = INDIRECT_FRIEND_VALUE;
                        continue;
                    }
                    
                    if (isY(st[j])) {
                        friends[i][j] = DIRECT_FRIEND_VALUE;
                        continue;
                    }
                    
                    if (isN(st[j])) {
                        friends[i][j] = MOCKED_INF_VALUE;
                    }
                }
            }
            
            // 플로이드 워셜
            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        //나 인 경우는 패스한다..
                        if (isMe(i, j)) {
                            continue;
                        }
                        
                        //중간 노드 k , 출발 i , 도착 j -> 중간 노드를 하나씩두고 만약 거쳐간 경우의 최소 거리를 찾는다.
                        setShortestCount(friends, i, j, k);
                    }
                }
            }
            
            // 2- 친구수 계산
            int maxFriend = 0;
            
            for (int i = 0; i < N; i++) {
                int friendCount = 0;
                for (int j = 0; j < N; j++) {
                    if (isMe(i, j)) {
                        continue;
                    }
                    
                    if (isTwoFriends(j, friends[i])) {
                        friendCount++;
                    }
                }
                
                maxFriend = Math.max(maxFriend, friendCount);
            }
            
            System.out.println(maxFriend);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void setShortestCount(int[][] friends, int i, int j, int k) {
        // 친구 i -> j  거리값이  = 친구 i -> k + 친구 k -> j 거리값 보다 크다면 친구 i -> j 거리값을 친구 i -> k + 친구 k -> j 거리값으로 설정한다.
        if (friends[i][j] > friends[i][k] + friends[k][j]) {
            friends[i][j] = friends[i][k] + friends[k][j];
        }
    }
    
    // 특정 사용자의 친구가 2명 이하인지 확인
    private static boolean isTwoFriends(int j, int[] friends) {
        return friends[j] <= 2;
    }
    
    private static boolean isMe(int i, int j) {
        return i == j;
    }
    
    private static boolean isN(String ny) {
        return Objects.equals(ny, "N");
    }
    
    private static boolean isY(String ny) {
        return Objects.equals(ny, "Y");
    }
}
