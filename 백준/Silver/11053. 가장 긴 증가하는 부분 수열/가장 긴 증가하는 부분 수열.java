import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {

            dp[i] = 1;

            // 내 왼쪽을 살펴봐야함
            for (int j = 0; j < i; j++) {

                if (arr[j] < arr[i] && dp[j] + 1> dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int l : dp) {
            if (max < l) {
                max = l;
            }
        }
        
        System.out.println(max);
    }
}