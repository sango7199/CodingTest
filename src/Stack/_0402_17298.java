package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _0402_17298 {
    public static void main(String[] args) throws IOException {
        // 선언 및 입력
        Stack<Integer> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] A = new int[N];
        int MAX = 0;
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if (A[i] > MAX) MAX = A[i];
        }

        // NGE 계산
        for (int i = 0; i < N; i++) {
            while (!stk.isEmpty() && stk.peek() < A[i]) {
                stk.pop();
                sb.append(A[i] + " ");
            }

            stk.push(A[i]);

            if (!stk.isEmpty() && MAX == stk.peek()) { // MAX A값은 NGE가 없으므로 -1
                stk.pop();
                sb.append("-1 ");
            }
        }

        while (!stk.isEmpty()) { // NGE(N)은 -1
            stk.pop();
            sb.append("-1 ");
        }

        // 출력
        System.out.print(sb.toString());
    }
}
