package Stack;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _0304_1874 {
    private static int[] stk; // 스택용 배열
    private static int ptr; // 스택 포인터
    public _0304_1874 (int maxlen) {
        stk = new int[maxlen];
        ptr = 0;
    }
    public void push(int x) {
        stk[ptr++] = x;
    }
    public int pop() {
        return stk[--ptr];
    }
    public int peek() {
        return stk[ptr - 1];
    }
    public boolean isEmpty() {
        return ptr <= 0;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        _0304_1874 s = new _0304_1874(N); // 스택 생성자
        int[] seq = new int[N]; // 수열 배열
        for (int i = 0; i < N; i++) {
            seq[i] = sc.nextInt();
        }

        int seqLocation = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            s.push(i);
            result.append("+\n");
            while (!s.isEmpty() && s.peek() == seq[seqLocation]) {
                s.pop();
                result.append("-\n");
                seqLocation++;
            }
        }

        if (!s.isEmpty()) {
            bw.write("NO");
        } else {
            bw.write(result.toString());
        }

        bw.flush();
        bw.close();
    }
}
