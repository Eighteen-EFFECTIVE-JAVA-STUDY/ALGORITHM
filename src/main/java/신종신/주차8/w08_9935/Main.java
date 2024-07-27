package 신종신.주차8.w08_9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String boom = br.readLine();

        int str_size = str.length();
        int boom_size = boom.length();

        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < str_size; i++){
            ans.append(str.charAt(i));
            if(ans.length() >= boom_size){
                if(ans.substring(ans.length() - boom_size, ans.length()).equals(boom)){
                    ans.delete(ans.length() - boom_size, ans.length());
                }
            }
        }
        if(ans.toString().equals("")){
            System.out.println("FRULA");
        } else {
            System.out.println(ans);
        }
    }
}
