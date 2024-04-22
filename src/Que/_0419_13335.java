package Que;

import java.util.LinkedList;
import java.util.Scanner;

public class _0419_13335 {
    // 트럭
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 트럭의 개수 n
        int w= sc.nextInt(); // 다리의 길이 w
        int L= sc.nextInt(); // 다리의 최대하중 L

        LinkedList<int[]> que = new LinkedList<>();
        int[] trucks = new int[n]; // 트럭 배열
        for (int i = 0; i < n; i++) {
            trucks[i] = sc.nextInt();
        }

        int curWeight = 0; // 현재 하중
        int time = 0; // 출력할 최단시간
        int index = 0; // 현재 트럭의 인덱스

        while (index < n || !que.isEmpty()) {
            if (!que.isEmpty() && que.peek()[1] == w) { // 다리를 빠져나가는 트럭 처리
                curWeight -= que.poll()[0];
            }

            if (index < n && (curWeight + trucks[index]) <= L && que.size() <= w) { // 다리에 들어오는 트럭 처리
                que.add(new int[] {trucks[index], 0}); // [ 트럭의 무게, 해당 트럭의 이동 카운트 ]
                curWeight += trucks[index];
                index++;
            }

            for (int[] curTrucks : que) { // 다리를 이동하는 트럭 업데이트
                curTrucks[1]++;
            }

            time++; // 시간 경과
        }
        sc.close();

        System.out.print(time);
    }
}
