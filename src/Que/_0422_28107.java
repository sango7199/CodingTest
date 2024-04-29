package Que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _0422_28107 {
    // 회전초밥 (HashMap ver)
    public static void main(String[] args) throws IOException {
        // 입력 및 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 손님의 수
        int M = Integer.parseInt(st.nextToken()); // 초밥의 수
        HashMap<Integer, ArrayList<Integer>> sushiPreferences = new HashMap<>(); // K 초밥 종류, V 손님 번호
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());; // 손님의 주문목록 갯수
            // 해당 손님의 주문 목록 배열을 크기 k로 초기화
            for (int j = 0; j < k; j++) {
                int A = Integer.parseInt(st.nextToken());
                sushiPreferences.putIfAbsent(A, new ArrayList<>());
                sushiPreferences.get(A).add(i);
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
            if(sushiPreferences.containsKey(curSushi)) {
                for (int customer : sushiPreferences.get(curSushi)) {
                    sushiEaten[customer]++;
                    break;
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int count : sushiEaten) {
            sb.append(count).append(" ");
        }
        System.out.print(sb.toString());
    }
}