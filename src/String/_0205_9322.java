package String;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _0205_9322 {
    // 철벽 보안 알고리즘
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스
        for (int i = 0; i < T; i++) { // 테스트 케이스 수만큼 반복
            int n = Integer.parseInt(br.readLine()); // 한 문장의 단어 수

            List<String> firstPublicKey = inputString(n);; // 제 1 공개키
            List<String> secondPublicKey = inputString(n);; // 제 2 공개키
            List<String> cipherText = inputString(n);; // 암호문

            int[] rule = new int[n]; // 배치 규칙을 저장하는 배열

            // 제 2 공개키와 제 1 공개키의 규칙 찾기
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (Objects.equals(secondPublicKey.get(j), firstPublicKey.get(k))) {
                        rule[j] = k;
                        break;
                    }
                }
            }

            // 규칙 찾았으니 암호문을 평문으로 바꾼 뒤 출력
            String[] plainText = new String[n]; // 평문
            for (int j = 0; j < n; j++) {
                plainText[rule[j]] = cipherText.get(j);
            }

            for (int j = 0; j < n; j++) {
                bw.write(plainText[j] + " ");
            }
            if (i != T -1) bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    // 키 입력 메소드
    static public List<String> inputString(int n) throws IOException {
        String str = br.readLine();

        String[] tokens = str.split(" ");
        List<String> list = new ArrayList<>(n);

        for (int i = 0; i < tokens.length; i++) {
            list.add(tokens[i]);
        }

        return list;
    }
}
