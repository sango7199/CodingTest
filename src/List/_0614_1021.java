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

        int size = N; // 현재 큐의 크기
        int Rsize = size; // 해당 수의 위치를 추적할 오른쪽 변수
        int cnt = 0; // 출력 : 연산의 최솟값
        for (int i = 1; i <= M; i++) {
            int element = sc.nextInt(); // 현재 원소
            int R = (Rsize - element) + 1;
            int L = size - R;
            if (L < R) { // 좌측이 더 작다면 좌측이 우측으로 이동하므로 Rsize +
                cnt += L;
                Rsize += L;
            } else { // 우측이 더 작다면 우측이 좌측으로 이동하므로 Rsize -
                cnt += R;
                Rsize -= R;
            }
            size--;
        }
        sc.close();

        // 출력
        System.out.print(cnt);
    }
}
