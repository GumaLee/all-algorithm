import java.util.*;
import java.io.*;

public class Main {

    final static int INF = 1 << 30;
    static int[] val;
    static int[][] dp;

    // 모든 전구를 동일한 색으로 바꾸기 위한 최소 횟수
    public static void main(String[] args) {
        // 경우의 수가 너무 많은데? -> 완전 탐색으로는 힘들겠다 -> DP를 생각해봐야겠다.
        // 어떻게 하면 작은 단위의 문제들로 쪼개고 해결할 수 있을까?
        Scanner sc = new Scanner(System.in);

        // 0. 입력 받으며 중복 숫자 제거
        int N = sc.nextInt();
        int K = sc.nextInt();

        val = new int[N + 1];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            val[i] = sc.nextInt();
            if(val[i] == val[i - 1]) {
                N--;
                i--;
            }
        }

        // 1. dp 배열 초기화 : i ~ j 까지의 전구를 하나로 통합하기 위한 최소 비용
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = INF;
            }
            dp[i][i] = 0;
        }

        //2. 두 개 이상의 전구들 간의 최솟값 계산
        for (int size = 2; size <= N; size++) {
            for(int start = 1; start <= N - size + 1; start++) {
                int end = start + size - 1;
                for (int mid = start; mid < end; mid++) {
                    int newValue = dp[start][mid] + dp[mid + 1][end];
                    if (val[start] != val[mid + 1]) newValue++;
                    if (dp[start][end] > newValue) dp[start][end] = newValue;
                }
            }
        }
        System.out.println(dp[1][N]);

        sc.close();
    }
}
