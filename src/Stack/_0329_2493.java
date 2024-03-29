package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _0329_2493 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<int[]> stk = new Stack<>(); // [ index, height ]
        br.close();

        int MAX = 0;
        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());

            if (height > MAX) {
                sb.append(0 + " ");
                MAX = height;
                stk.push(new int[] {i, height});
            } else {
                while (height >= stk.peek()[1]) {
                    stk.pop();
                }
                sb.append(stk.peek()[0] + " ");
                stk.push(new int[] {i, height});
            }

            stk.push(new int[] {i, height});
        }

        System.out.print(sb.toString());
    }
}
