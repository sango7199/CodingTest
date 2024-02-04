package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0204_11507 {
    // 카드셋트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();
        boolean[][] trumpCard = new boolean[4][13];
        int[] output = new int[4];
        boolean greska = false;
        int j = 0; // 문자열 카운트 변수
        for (int i = 0; i < input.length() / 3; i++) {
            int pattern = 0;
            int number = 0;
            switch (input.charAt(j++)) {
                case 'P':
                    pattern = 0;
                    break;
                case 'K':
                    pattern = 1;
                    break;
                case 'H':
                    pattern = 2;
                    break;
                case 'T':
                    pattern = 3;
                    break;

            }
            char[] temp = {input.charAt(j++), input.charAt(j++)};
            number = Integer.parseInt(new String(temp)) - 1; // 인덱스라서 -1
            if (!trumpCard[pattern][number]) {
                trumpCard[pattern][number] = true;
            } else {
                greska = true;
                break;
            }
        }
        if (greska) {
            System.out.print("GRESKA");
        } else {
            for (int i = 0; i < trumpCard.length; i++) {
                for (int k = 0; k < trumpCard[0].length; k++) {
                    if (!trumpCard[i][k]) {
                        output[i]++;
                    }
                }
            }
            for (int Output : output) {
                System.out.print(Output + " ");
            }
        }
    }
}
