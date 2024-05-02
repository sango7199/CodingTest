package Que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _0424_3078 {
    // 좋은 친구
    public static void main(String[] args) throws IOException {
        // 입력 및 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        Queue<String> que = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>(); // K 이름의 길이, V 같은 이름의 길이를 가진 학생들의 수
        long goodFriendCnt = 0;

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            int curLength = name.length();

            if (que.size() > K) { // K 범위를 넘어가는 학생을 큐와 맵에서 제거
                String oldName = que.poll();
                int oldLength = oldName.length();
                map.put(oldLength, map.get(oldLength) - 1);
            }

            if (map.containsKey((curLength))) { // 현재 이름 길이와 같은 학생 수를 맵에서 가져와 좋은 친구 쌍에 추가
                goodFriendCnt += map.get(curLength);
            }

            // 큐와 맵에 현재 학생 추가
            que.add(name);
            map.put(curLength, map.getOrDefault(curLength, 0) + 1);
        }

        // 출력
        System.out.println(goodFriendCnt);
    }
}
