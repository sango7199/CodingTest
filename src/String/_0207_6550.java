package String;

import java.io.*;

public class _0207_6550 {
    // 부분 문자열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while ((input = br.readLine()) != null) {
            String[] str = input.split(" ");
            if (str[1].contains(str[0])) {
                bw.write("Yes" + "\n");
            } else {
                int count = 0;
                int l = 0;
                for (int j = 0; j < str[0].length(); j++) {
                    for (int k = l; k < str[1].length(); k++) {
                        if (str[0].charAt(j) == str[1].charAt(k)) {
                            count++;
                            l = k + 1;
                            break;
                        }
                    }
                }
                if (count == str[0].length()) {
                    bw.write("Yes" + "\n");
                } else {
                    bw.write("No" + "\n");
                }
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
