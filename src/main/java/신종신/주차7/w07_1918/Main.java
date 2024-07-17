package 신종신.주차7.w07_1918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        Stack<Character> s = new Stack<>();


        for(char word : str.toCharArray()){
            if('A' <= word && word <= 'Z'){
                sb.append(word);
                continue;
            }

            if (word == '(') {
                s.push(word);
            } else if (word == ')') {
                while(!s.empty() && s.peek() != '('){
                    sb.append(s.peek());
                    s.pop();
                }
                s.pop();
            } else if (word == '*' || word == '/') {
                while(!s.empty() && (s.peek() == '*' || s.peek() == '/')){
                    sb.append(s.peek());
                    s.pop();
                }
                s.push(word);
            } else if (word == '+' || word == '-') {
                while(!s.empty() && s.peek() != '('){
                    sb.append(s.peek());
                    s.pop();
                }
                s.push(word);
            }
        }

        while(!s.empty()){
            sb.append(s.peek());
            s.pop();
        }

        System.out.println(sb);
    }
}
