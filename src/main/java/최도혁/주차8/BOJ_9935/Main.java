package 최도혁.주차8.BOJ_9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String FRULA = "FRULA";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String trigger = br.readLine();
        int triggerLength = trigger.length();

        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            sb.append(c);
            if (sb.length() >= triggerLength) {
                boolean match = true;
                for (int i = 0; i < triggerLength; i++) {
                    if (sb.charAt(sb.length() - triggerLength + i) != trigger.charAt(i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    sb.delete(sb.length() - triggerLength, sb.length());
                }
            }
        }

        System.out.print(sb.length() == 0 ? FRULA : sb.toString());
    }
}
