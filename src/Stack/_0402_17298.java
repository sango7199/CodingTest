package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _0402_17298 {
    public static void main(String[] args) throws IOException {
        // 선언 및 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] NGE = new int[N];
        Stack<Integer> stk = new Stack<>();

        // 수열 A 입력과 출력할 NGE에 -1을 초기값 설정
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            NGE[i] = -1;
        }

        // NGE 입력
        for (int i = 0; i < N; i++) {
            while (!stk.isEmpty() && A[i] > A[stk.peek()]) {
                NGE[stk.peek()] = A[i];
                stk.pop();
            }
            stk.push(i);
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int nge: NGE
             ) {
            sb.append(nge + " ");
        }
        System.out.print(sb.toString());
    }
}
