package eddy.주차8.w8_9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String string = br.readLine();
        int stringLength = string.length();

        Stack<Character> st = new Stack<>();

        for(int i = 0; i<input.length(); i++){
            st.push(input.charAt(i));  // push()로 스택에 값 추가

            //문자열이 폭발 문자열보다 길이가 작으면 폭발할 수 없음
            if(st.size() >= stringLength) {
                boolean flag = true;


                for(int j = 0; j<stringLength; j++){
                    if(st.get(st.size() - stringLength+j) != string.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                //폭발 문자열일 때
                if(flag) {
                    for(int j = 0; j<stringLength; j++){
                        st.pop();  //pop()으로 스택에 값 빼내면서 반환
                    }
                }
            }
        }

        //stack에 저장된 정보 저장
        StringBuilder sb = new StringBuilder();
        for(Character c:st) {
            sb.append(c);
        }
        if(sb.length()>0)
            System.out.println(sb.toString());
        else
            System.out.println("FRULA");
    }
}
