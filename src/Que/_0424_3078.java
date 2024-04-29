package Que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _0424_3078 {
    // 좋은 친구
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<int[]> que = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String curStudent = br.readLine();
            for (int j = 0; j < K; j++) {
                // 일단 여기까지 너무 잠 옴
            }
            que.add(new int[] {i, curStudent.length(), 0}); // [ 등수, 이름 길이, 카운트 ]
        }
    }
}
