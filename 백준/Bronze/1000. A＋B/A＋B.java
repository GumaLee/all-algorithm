import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        // 아스키코드 : 0 ~ 9 -> 80 ~ 89
        // 정수 A, B = 0과 10 사이의 정수
        int sum = 0;
        while(token.hasMoreTokens()) {
            sum += Integer.parseInt((token.nextToken())); // 이건 아스키코드로 변환되는게 아니라 진짜 "4" -> 4로 변환이네
        }
        System.out.println(sum);
    }
}