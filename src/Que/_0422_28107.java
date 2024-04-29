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
        HashMap<Integer, HashSet<Integer>> eatenSushi = new HashMap<>(); // K 손님 번호, V 먹은 초밥 종류
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());; // 손님의 주문목록 개수
            for (int j = 0; j < k; j++) {
                int A = Integer.parseInt(st.nextToken());
                sushiPreferences.putIfAbsent(A, new ArrayList<>());
                sushiPreferences.get(A).add(i);
            }
            eatenSushi.put(i, new HashSet<>()); // 각 손님 별로 먹은 초밥
        }

        Queue<Integer> sushi = new LinkedList<>(); // 회전 초밥
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sushi.add(Integer.parseInt(st.nextToken()));
        }
        int[] numberOfSushiEaten = new int[N]; // 각 손님이 먹은 초밥의 개수 배열 (출력값)

        // 먹힌 초밥 계산
        while(!sushi.isEmpty()) {
            int curSushi = sushi.poll(); // 현재 스시
            if (sushiPreferences.containsKey(curSushi)) {
                for (int customer : sushiPreferences.get(curSushi)) {
                    if(!eatenSushi.get(customer).contains(curSushi)) {
                        numberOfSushiEaten[customer]++; // 손님이 먹은 초밥 개수 ++
                        eatenSushi.get(customer).add(curSushi); // 손님이 해당 초밥을 먹음
                        break; // 첫 번째 먹을 수 있는 손님에게 주고 종료
                    }
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int count : numberOfSushiEaten) {
            sb.append(count).append(" ");
        }
        System.out.print(sb.toString().trim());
    }
}