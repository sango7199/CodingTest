package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _0319_1918 {
    static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        else if (op == '*' || op == '/') return 2;
        else return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        String str = br.readLine();
        br.close();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                sb.append(c);
            } else if (c == '(') {
                stk.push(c);
            } else if (c == ')') {
                while (!stk.isEmpty() && stk.peek() != '(')
                    sb.append(stk.pop());
                if (!stk.isEmpty()) stk.pop();
            } else {
                while (!stk.isEmpty() && precedence(stk.peek()) >= precedence(c))
                    sb.append(stk.pop());
                stk.push(c);
            }
        }

        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }

        System.out.print(sb.toString());
    }
}