package 박상준.백준.주차2.회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * packageName    : 박상준.백준.주차2.회의실배정
 * fileName       : Main
 * author         : ipeac
 * date           : 24. 6. 10.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 10.        ipeac       최초 생성
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        List<Pair> meetings = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            //StringTokener 사용시 객체 계속 생성되어 속도 느려짐
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            
            meetings.add(new Pair(start, end));
        }
        
        meetings.sort(Comparator.comparingInt(Pair::getEnd).thenComparingInt(Pair::getStart));
        
        int maxUse = 1;
        
        Pair currentMeeting = meetings.get(0);
        
        for (int i = 1; i < N; i++) {
            Pair nextMeeting = meetings.get(i);
            
            if (currentMeeting.canStartNextMeetingByGiven(nextMeeting)) {
                maxUse++;
                currentMeeting = nextMeeting;
            }
        }
        
        System.out.println(maxUse);
    }
    
    static class Pair {
        int start;
        int end;
        
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        public int getEnd() {
            return this.end;
        }
        
        public int getStart() {
            return this.start;
        }
        
        public boolean canStartNextMeetingByGiven(Pair nextMeeting) {
            //현재 미팅의 종료시간보다 <= 다음 미팅의 시작시간
            if (this.end <= nextMeeting.start) {
                return true;
            }
            
            return false;
        }
    }
}
