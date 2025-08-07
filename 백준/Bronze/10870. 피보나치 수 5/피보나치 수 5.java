import java.io.*;
import java.util.*;


public class Main {

    /**
     * 피보나치 수열 값 구하기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Integer[] fibonacci = new Integer[21];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i < 21; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }

        int n = Integer.parseInt(br.readLine());

        System.out.print(fibonacci[n]);
    }
}