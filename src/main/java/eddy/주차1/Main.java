package eddy.주차1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * packageName    : eddy.주차1.9996
 * fileName       : Main
 * author         : ipeac
 * date           : 24. 5. 31.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 5. 31.        ipeac       최초 생성
 */
public class Main {
    public static void main(String[] args) {

        int countNo;
        String pattern;

        Scanner sc = new Scanner(System.in);
        countNo = Integer.parseInt(sc.nextLine());
        pattern = sc.nextLine();
        List<String> fileList = new ArrayList<String>();
        for (int i = 0; i < countNo; i++) {
            String temp;
            temp = sc.nextLine();
            fileList.add(temp);
        }



        String[] patterns = pattern.split("\\*");


        for (int i = 0; i < countNo; i++) {
            //
            if ((fileList.get(i).startsWith(patterns[0])) && (fileList.get(i).endsWith(patterns[1])) && (fileList.get(0).length() >= patterns[0].length() + patterns[1].length())) {
                System.out.println("DA");
            } else {
                System.out.println("NE");


            }

        }

    }
}