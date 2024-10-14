import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        arr[0] = 0;

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[N + 1];

        System.out.println(solve(N, arr));
    }

    private static int solve(int n, int[] arr) {

        /**
         * dp[0] = 0
         * dp[1] = dp[0] + arr[0]
         * dp[2] = dp[0] + arr[2] | dp[1] + arr[2]
         * dp[3] = dp[1] + arr[3] | dp[0] + arr[2] + arr[3]
         * ...
         * dp[N] = dp[N-2] + arr[N] | dp[N-3] + arr[N-1] + arr[N]
         */
        if (n == 1) {
            return arr[1];
        } else if (n == 2) {
            return arr[2] + arr[1];
        }

        if (n >= 3) {
            dp[1] = arr[1];
            dp[2] = dp[1] + arr[2];

            for (int i = 3; i < n + 1; i++) {
                dp[i] = Math.max(dp[i - 2] + arr[i], dp[i-3] + arr[i-1] + arr[i]);
            }
        }

        return dp[n];
    }
}