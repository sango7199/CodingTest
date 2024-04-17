package Que;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _0416_14729 {
    // 칠무해
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 우선순위 큐
        PriorityQueue<Float> priQue = new PriorityQueue<>(7, Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            float score = sc.nextFloat();
            if (priQue.size() < 7) {
                priQue.offer(score);
            } else {
                if (score < priQue.peek()) {
                    priQue.poll();
                    priQue.offer(score);
                }
            }
        }
        sc.close();

        // 정렬 후 출력
        PriorityQueue<Float> sortedPriQue = new PriorityQueue<>();
        while (!priQue.isEmpty()) {
            sortedPriQue.add(priQue.poll());
        }

        while (!sortedPriQue.isEmpty()) {
            System.out.printf("%.3f\n", sortedPriQue.poll());
        }
    }
}
