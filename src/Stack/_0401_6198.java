package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _0401_6198 {
    public static void main(String[] args) throws IOException {
        // 입력 및 선언
        Stack<Integer> stk = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long total = 0;

        // 벤처마킹 가능한 빌딩의 수 계산
        for (int i = 0; i < N; i++) {
            int H = Integer.parseInt(br.readLine());

            while (!stk.isEmpty() && stk.peek() <= H) {
                stk.pop();
            }

            total += stk.size();

            stk.push(H);
        }
        br.close();

        // 출력
        System.out.print(total);
    }
}
