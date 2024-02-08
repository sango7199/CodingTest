package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0208_14425 {
    // 문자열 집합
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NMInput = br.readLine().split(" ");
        int N = Integer.parseInt(NMInput[0]);
        int M = Integer.parseInt(NMInput[1]);
        String[] includedStrings = new String[N];
        int output = 0;
        for (int i = 0; i < N; i++) {
            includedStrings[i] = br.readLine();
        }
        for (int i = 0; i < M; i++) {
            String toBecheckString = br.readLine();
            for (int j = 0; j < N; j++) {
                if (toBecheckString.equals(includedStrings[j])) output++;
            }
        }
        System.out.print(output);

    }
}
