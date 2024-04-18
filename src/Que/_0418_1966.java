package Que;

import java.util.LinkedList;
import java.util.Scanner;

public class _0418_1966 {
    // 프린터 큐
    public static void main(String[] args) {
        // 입력 및 선언
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N; int M; int Pri; // Priority
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            LinkedList<int[]> que = new LinkedList<>();
            N = sc.nextInt(); // 문서의 갯수
            M = sc.nextInt(); // 출력해야 할 문서의 인덱스 번호
            for (int j = 0; j < N; j++) {
                Pri = sc.nextInt();
                que.add(new int[]{Pri, j}); // [ Priority, index ]
            }

            int printCnt = 0; // 인쇄한 문서의 수
            while(!que.isEmpty()) { //
                int[] curDoc = que.poll(); // 현재 문서
                boolean isPrintable = true;
                for (int[] doc: que) { // 우선순위 비교
                    if (doc[0] > curDoc[0]) {
                        isPrintable = false;
                        break;
                    }
                }
                if (isPrintable) { // 인쇄 가능한 경우 출력
                    printCnt++;
                    if (curDoc[1] == M) { // 출력한 문서의 인덱스가 M과 같다면
                        sb.append(printCnt + "\n"); // 기록
                        break;
                    }
                } else { // 인쇄 불가능한 경우 뒤로
                    que.add(curDoc);
                }
            }
        }
        sc.close();

        System.out.print(sb.toString());
    }
}
