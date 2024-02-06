package String;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class _0206_11478 {
    // 서로 다른 부분 문자열의 개수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        Set<String> subString = new HashSet<>();

        for (int i = 1; i <= str.length(); i++) {
            int begin = 0;
            int end = i;
            for (int j = str.length(); j > i - 1; j--) {
                subString.add(str.substring(begin++, end++));
                }
            }
        System.out.print(subString.size());
    }
}
