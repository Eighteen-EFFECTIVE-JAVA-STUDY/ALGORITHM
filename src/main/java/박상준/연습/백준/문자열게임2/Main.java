package 박상준.연습.백준.문자열게임2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * packageName    : 박상준.연습.백준.문자열게임2
 * fileName       : Main
 * author         : sjunpark
 * date           : 24. 12. 16.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 16.        sjunpark       최초 생성
 */
public class Main {
    /*
    2
        superaquatornado
        2
        abcdefghijklmnopqrstuvwxyz
        5
        */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int T = Integer.parseInt(br.readLine());
            
            for (int i = 0; i < T; i++) {
                String W = br.readLine();
                int K = Integer.parseInt(br.readLine());
                
                mainLogic(W, K);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void mainLogic(final String w, final int k) {
        Objects.requireNonNull(w);
        
        int maxConsecutiveWord = -1;
        //어떤 문자를 정확하게 K개를 포함하는 가장 짧은 연속 문자열의 길이
        int start = 0;
        final int end = w.length() - 1;
        
        for (int i = start; i < end; i++) {
        
        }
        
        //슬라이딩 윈도우 기법
    }
}
