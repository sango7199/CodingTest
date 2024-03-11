package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _0311_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Character> s = new Stack<Character>();

        int count = 0;
        for (int i = 0; i < N; i++) {
            s.clear();
            char[] input = br.readLine().toCharArray();
            for (char c : input) {
                if (!s.isEmpty() && s.peek() == c) {
                    s.pop();
                } else {
                    s.push(c);
                }
            }
            if (s.isEmpty()) count++;
        }
        br.close();
        System.out.print(count);
    }
}