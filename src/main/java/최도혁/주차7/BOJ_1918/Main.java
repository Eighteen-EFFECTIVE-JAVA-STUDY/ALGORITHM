package 최도혁.주차7.BOJ_1918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character,Integer> priority = new HashMap<>();
        priority.put('*',2); priority.put('/',2);
        priority.put('+',1); priority.put('-',1);
        priority.put('(',0);

        String infix = br.readLine();
        StringBuilder postfix = new StringBuilder();


        for(Character ch : infix.toCharArray()){
            if(ch >= 'A' && ch <= 'Z') {
                postfix.append(ch);
            }
            else if(ch != '(' && ch != ')'){
                while(!stack.empty() && priority.get(ch) <= priority.get(stack.peek())){
                    postfix.append(stack.pop());
                }
                stack.add(ch);
            }

            else if(ch == '(') {
                stack.add(ch);
            }
            else {
                while(stack.peek() != '('){
                    postfix.append(stack.pop());
                }
                stack.pop();
            }

        }
        while(!stack.empty()){
            postfix.append(stack.pop());
        }
        System.out.print(postfix);
    }
}
