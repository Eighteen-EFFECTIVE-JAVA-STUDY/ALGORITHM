package Do.W01_9996;

import java.io.*;

/**
 * packageName    : Do.W01_9996
 * fileName       : Main
 * author         : ehgur
 * date           : 24. 6. 3.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 3.         ehgur            최초 생성
 */
public class Main {

    private static String[] pattern;
    private static final String SUCCESS = "DA";
    private static final String FAIL = "NE";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        pattern = br.readLine().split("\\*"); // +,*,^ 등등 정규 표현식에서 특별한 의미로 쓰이기에 escape 문자 사용

        while (t-- > 0) {
            String fileName = br.readLine();
            String result = checkPattern(fileName);
            bw.write(result);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static String checkPattern(String fileName) {

        if (checkLength(fileName) && fileName.startsWith(pattern[0]) &&
                fileName.endsWith(pattern[1])) {
            return SUCCESS;
        }
        return FAIL;
    }

    private static boolean checkLength(String fileName) {
        return fileName.length() >= pattern[0].length() + pattern[1].length();
    }
}