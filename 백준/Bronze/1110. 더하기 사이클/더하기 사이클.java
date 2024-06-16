import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        // num : 처음 숫자
        int tmp = num;
        int a, b, c;
        int cnt = 0;

        while(true) {
            a = tmp / 10;
            b = tmp % 10;
            c = a + b;
            tmp = (10 * b) + (c % 10);

            if(tmp == num) {
                cnt++;
                break;
            }
            else {
                cnt++;
                continue;
            }
        }
        System.out.println(cnt);
    }
}