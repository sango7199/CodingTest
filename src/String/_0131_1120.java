package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class _0131_1120 {
    // 문자열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        final String B = st.nextToken();
        br.close();
        int output = 0;
        if (A.length() == B.length()) {
            output = compareToString(A ,B);
        } else {
            int[] MAX = new int[2];
            for (int i = 0; i < B.length() - A.length() + 1; i++) {
                int count = 0;
                int k = i;
                for (int j = 0; j < A.length(); j++,k++) {
                    if (A.charAt(j) == B.charAt(k)) count++;
                }
                if (MAX[0] < count) {
                    MAX[0] = count;
                    MAX[1] = i;
                }
            }
            String C = "";
            if (MAX[1] != 0) { // prefix 추가
                for (int i = 0; i < MAX[1]; i++) {
                    C += B.charAt(i);
                }
            }
            for (int i = 0; i < A.length(); i++) { // 문자열 A 추가
                C += A.charAt(i);
            }
            if (B.length() - C.length() >= 1) { // suffix 추가
                for (int i = C.length(); i < B.length(); i++) {
                    C += B.charAt(i);
                }
            }
            output = compareToString(C, B);
        }
        System.out.print(output);
    }

    // 문자열 비교 메소드
    static int compareToString(String X, String Y) {
        int count = 0;
        for (int i = 0; i < Y.length(); i++) {
            if (X.charAt(i) != Y.charAt(i)) count++;
        }
        return count;
    }
}
