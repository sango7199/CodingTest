package List;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class _0614_1021 {
    // 회전하는 큐
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            int index = 0; // 원소의 인덱스 위치
            for (Integer value : deque) { // 원소의 인덱스 위치 찾기
                if (value == target) {
                    break;
                }
                index++;
            }

            int left = index;
            int right = deque.size() - index;

            if (left <= right) { // 좌측이 작다면
                for (int j = 0; j < left; j++) {
                    deque.addLast(deque.removeFirst());
                    cnt++;
                }
            } else { // 우측이 작다면
                for (int j = 0; j < right; j++) {
                    deque.addFirst(deque.removeLast());
                    cnt++;
                }
            }
            deque.removeFirst();

        }

        // 출력
        System.out.print(cnt);
        sc.close();
    }
}