import java.io.IOException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            String str = new String();
            str = sc.nextLine();
            System.out.println("문자열 : " + str + ", 주소 : " + str.hashCode());
        }
    }
}
