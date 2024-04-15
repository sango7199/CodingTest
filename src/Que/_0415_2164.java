package Que;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _0415_2164 {
    // 카드 2
    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        // 1~N까지 입력
        for (int i = 1; i <= N; i++) {
            que.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N - 1; i++) {
            que.poll(); // 제일 위에 있는 카드를 바닥에 버림
            que.offer(que.poll()); // 그 다음 위에 있는 카드를 가장 밑으로 보냄
        }

        if (!que.isEmpty()) System.out.print(que.poll());
    }
}
