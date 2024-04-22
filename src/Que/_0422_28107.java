package Que;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _0422_28107 {
    // 회전초밥
    public static void main(String[] args) {
        // 입력 및 선언
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 손님의 수
        int M = sc.nextInt(); // 초밥의 수
        int[][] customers = new int[N][];
        for (int i = 0; i < N; i++) {
            int k = sc.nextInt(); // 손님의 주문목록 갯수
            customers[i] = new int[k]; // 해당 손님의 주문 목록 배열을 크기 k로 초기화
            for (int j = 0; j < k; j++) {
                customers[i][j] = sc.nextInt();
            }
        }
        Queue<Integer> sushi = new LinkedList<>(); // 회전 초밥
        for (int i = 0; i < M; i++) {
            sushi.add(sc.nextInt());
        }
        int[] sushiEaten = new int[N]; // 먹힌 초밥 (출력값)

        // 먹힌 초밥 계산
        while(!sushi.isEmpty()) {
            int curSushi = sushi.poll(); // 현재 스시
            loop : for (int i = 0; i < N; i++) {
                for (int j = 0; j < customers[i].length; j++) {
                    if (customers[i][j] == curSushi) {
                        sushiEaten[i]++;
                        break loop;
                    }
                }
            }
        }

        // 출력
        for (int output: sushiEaten) {
            System.out.print(output + " ");
        }
    }
}