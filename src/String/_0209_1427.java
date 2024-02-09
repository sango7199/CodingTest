package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _0209_1427 {
    // 소트인사이드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();
        int[] N = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            N[i] = input.charAt(i) - 48;
        }
        Arrays.sort(N);
        for (int i = 0; i < N.length / 2; i++) {
            int temp = N[i];
            N[i] = N[(N.length - 1) - i];
            N[(N.length - 1) - i] = temp;
        }

        for (int output:
             N) {
            System.out.print(output);
        }
    }
}
