package Stack;

import java.util.Scanner;
import java.util.Stack;

public class _0328_10773 {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt(); // 정수 K

        for (int i = 0; i < K; i++) {
            int N = sc.nextInt();
            if (N == 0) { // O이면 pop
                stk.pop();
            } else { // 아니라면 push
                stk.push(N);
            }
        }
        sc.close();

        int output = 0; // 출력 변수
        while (!stk.isEmpty()) { // 스택 남은 데이터 전부 pop
             output += stk.pop();
        }

        System.out.print(output); // 출력
    }
}
