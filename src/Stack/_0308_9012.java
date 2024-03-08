package Stack;

import java.io.*;

public class _0308_9012 {
    // 괄호문자열
    private static char[] stk; // 스택 배열
    private static int ptr; // 스택 포인터
    private static int capacity; // 스택 배열 용량

    // 생성자
    public _0308_9012(int maxlen) {
        capacity = maxlen;
        stk = new char[capacity];
        ptr = 0;
    }

    // 메소드
    public char push(char x) {
        return stk[ptr++] = x;
    }

    public char pop() {
        return stk[--ptr];
    }

    public char peek() {
        return stk[ptr - 1];
    }

    public char second() {
        return stk[ptr - 2];
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public int size() {
        return ptr;
    }

    public void clear() {
        ptr = 0;
    }

    public static void main(String[] args) throws IOException {
        _0308_9012 s = new _0308_9012(50);
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            s.clear(); // 스택 초기화
            String input = br.readLine();
            char[] PS = input.toCharArray();
            for (int j = 0; j < PS.length; j++) {
                s.push(PS[j]);
                if (s.size() > 1 && s.peek() == ')' && s.second() == '(') {
                    s.pop();
                    s.pop();
                }
            }
            if (s.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        br.close();
    }
}
