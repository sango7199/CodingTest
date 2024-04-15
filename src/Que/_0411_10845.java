package Que;

import java.io.*;
import java.util.StringTokenizer;

public class _0411_10845 {
    // 큐 (Queue) 링 버퍼로 구현
    private int[] que;      // 큐용 배열
    private int capacity;   // 큐의 용량
    private int front;      // 맨 앞의 요소 커서
    private int rear;       // 맨 뒤의 요소 커서
    private int num;        // 현재 데이터 개수

    public _0411_10845(int maxlen) {
        num = front = rear = 0;
        capacity = maxlen;
        que = new int[capacity];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        _0411_10845 intQue = new _0411_10845(N);

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int output = -2;
            switch (st.nextToken()) {
                case "push":
                    int X = Integer.parseInt(st.nextToken());
                    intQue.push(X);
                    break;
                case "pop":
                    output = intQue.pop();
                    break;
                case "size":
                    output = intQue.size();
                    break;
                case "empty":
                    output = intQue.empty();
                    break;
                case "front":
                    output = intQue.front();
                    break;
                case "back":
                    output = intQue.back();
                    break;
            }
            if (output != -2) System.out.println(output);
        }
    }

    public void push(int x) {
        if (num != capacity) {
            que[rear++] = x;
            num++;
        }
    }
    public int pop() {
        if (num == 0) {
            return -1;
        } else {
            num--;
            return que[front++];
        }
    }
    public int size() {
        return num;
    }
    public int empty() {
        if (num == 0) {
            return 1;
        } else {
            return 0;
        }
    }
    public int front() {
        if (num == 0) {
            return -1;
        } else {
            return que[front];
        }
    }
    public int back() {
        if (num == 0) {
            return -1;
        } else {
            return que[rear - 1];
        }
    }
}
