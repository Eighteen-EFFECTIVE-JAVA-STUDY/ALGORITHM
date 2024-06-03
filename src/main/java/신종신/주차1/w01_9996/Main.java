package 신종신.주차1.w01_9996;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String[] s = pattern.split("\\*");

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            if(str.length() < s[0].length() + s[1].length()){
                System.out.println("NE");
                continue;
            }

            String st = str.substring(0, s[0].length());
            String en = str.substring(str.length() - s[1].length(), str.length());

            if(st.equals(s[0]) && en.equals(s[1])){
                System.out.println("DA");
            }
            else{
                System.out.println("NE");
            }
        }
    }
}
