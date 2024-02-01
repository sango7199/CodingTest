package String;

import java.util.Scanner;

public class _0201_1439 {
    // 뒤집기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        sc.close();
        int[] arr = new int[2];
        for (int i = 0; i < S.length(); i++) {
            if (i == 0) { // 첫 번째 인덱스는 기록
                if (S.charAt(i) == '0') arr[0]++;
                else { arr[1]++; }
            } else { // 두 번째 인덱스부터는 숫자가 바뀌는 시점부터 카운트
                if (S.charAt(i) != S.charAt(i-1)) {
                    if (S.charAt(i) == '0') {
                        arr[0]++;
                    } else {
                        arr[1]++;
                    }
                }
            }
        }
        int output = Math.min(arr[0], arr[1]);
        System.out.print(output);
    }
}
