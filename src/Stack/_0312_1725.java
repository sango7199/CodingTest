package Stack;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class _0312_1725 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] height = new long[N];
        Set<Long> s = new HashSet<>();

        for (int i = 0; i < N; i++) {
            Long input = sc.nextLong();
            height[i] = input;
            s.add(input);
        }

        long MAX = 0;
        long count;
        long countMAX;
        for (Long l : s) {
            count = 0;
            countMAX = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] >= l) {
                    count++;
                } else {
                    countMAX = Math.max(count, countMAX);
                    count = 0;
                }
            }
            MAX = Math.max(countMAX * l, MAX);
        }

        System.out.print(MAX);
    }
}
