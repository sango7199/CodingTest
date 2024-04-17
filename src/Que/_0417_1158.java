package Que;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _0417_1158 {
    // 요세푸스 문제
    public static void main(String[] args) {
        // 입력 및 선언
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.close();

        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            que.offer(i);
        }

        // 순열 구하기
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j == K) {
                    sb.append(que.poll());
                } else {
                    que.offer(que.poll());
                }
            }
            if (i == N) {
                sb.append(">");
            } else {
                sb.append(", ");
            }
        }

        // 출력
        System.out.print(sb.toString());
    }
}
