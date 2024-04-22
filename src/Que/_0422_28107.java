package Que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _0422_28107 {
    // 회전초밥 (입력 BR ver)
    public static void main(String[] args) throws IOException {
        // 입력 및 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 손님의 수
        int M = Integer.parseInt(st.nextToken()); // 초밥의 수
        int[][] customers = new int[N][];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());; // 손님의 주문목록 갯수
            customers[i] = new int[k]; // 해당 손님의 주문 목록 배열을 크기 k로 초기화
            for (int j = 0; j < k; j++) {
                customers[i][j] = Integer.parseInt(st.nextToken());;
            }
        }
        Queue<Integer> sushi = new LinkedList<>(); // 회전 초밥
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sushi.add(Integer.parseInt(st.nextToken()));
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