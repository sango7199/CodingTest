package Stack;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _0228_10828 {
    private int[] stk;
    private int capacity;
    private int ptr;

    public _0228_10828(int maxlen) {
        capacity = maxlen;
        stk = new int[capacity];
        ptr = 0;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        _0228_10828 s = new _0228_10828(N);
        for (int i = 0; i <= N; i++) {
            String order = sc.nextLine();
            if (order.contains("push")) {
                String[] pushVal = order.split(" ");
                s.push(Integer.parseInt(pushVal[1]));
            } else {
                switch (order) {
                    case "pop":
                        bw.write(s.pop() + "\n");
                        break;
                    case "size":
                        bw.write(s.size() + "\n");
                        break;
                    case "empty":
                        bw.write(s.empty() + "\n");
                        break;
                    case "top":
                        bw.write(s.top()+ "\n");
                        break;
                }
            }
        }
        bw.flush();
        bw.close();
    }
    public void push(int x) {
        stk[ptr++] = x;
    }
    public int pop() {
        if (ptr <= 0) {
            return -1;
        } else {
            return stk[--ptr];
        }
    }
    public int size() {
        return ptr;
    }
    public int empty() {
        if (ptr <= 0) {
            return 1;
        } else {
            return 0;
        }
    }
    public int top() {
        if (ptr <= 0) {
            return -1;
        } else {
            return stk[ptr - 1];
        }
    }
}
