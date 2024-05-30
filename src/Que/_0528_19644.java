package Que;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class _0528_19644 {
    // 좀비 떼가 기관총 진지에도 오다니
    public static void main(String[] args) {
        // 입력 및 선언
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt(); // 진지 앞쪽 거리
        int ML = sc.nextInt(); // 기관총 사거리
        int MK = sc.nextInt(); // 기관총 살상력
        int C = sc.nextInt(); // 수평 지뢰 살상력
        int[] zombies = new int[L];
        for (int i = 0; i < L; i++) { // 좀비 체력 입력
            zombies[i] = sc.nextInt();
        }
        Deque<Integer> deque = new LinkedList<>(); // 현재 좀비의 체력을 저장하는 덱
        sc.close();

        String survivalStatus = "YES"; // 생존여부
        for (int i = 0; i < L; i++) {
            deque.addLast(zombies[i]); // 현재 좀비를 덱에 추가

            if (deque.size() > ML) deque.removeFirst(); // 사정거리 밖으로 나간 좀비 덱에서 제거

            if (deque.peekFirst() > MK && C > 0) { // 1M에 위치한 좀비의 체력이 살상력보다 높을 경우 (지뢰)
                C--; // 지뢰 사용
                deque.removeFirst();
            } else { // 1M에 위치한 좀비의 체력이 살상력보다 낮을 경우 (사격)
                for (int j = 0; j < deque.size(); j++) { // 사정거리에 있는 좀비들의 체력 MK만큼 체력 감소
                    int curZombieHP = deque.removeFirst();
                    curZombieHP -= MK;
                    deque.addLast(curZombieHP);
                }

                if (deque.peekFirst() > 0) { // 사격 후 1M에 위치한 좀비가 살아있다면 fail
                    survivalStatus = "NO";
                    break;
                }
            }


        }
        // 출력
        System.out.print(survivalStatus);
    }
}
