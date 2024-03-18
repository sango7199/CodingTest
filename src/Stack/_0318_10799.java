package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _0318_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stk = new Stack<>();
        br.close();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stk.push(c);
            } else { // (c == ')')
                if (s.charAt(i - 1) == '(') {
                    stk.pop();
                    count += stk.size();
                } else { // (s.charAt(i - 1) == ')')
                    stk.pop();
                    count += 1;
                }
            }
        }
        System.out.print(count);
    }
}
