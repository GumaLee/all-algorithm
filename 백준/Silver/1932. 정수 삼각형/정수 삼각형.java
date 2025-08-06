import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Integer[][] matrix;
    static Integer[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 크기 받기
        n = Integer.parseInt(br.readLine());

        // 입력 값 2차원 배열
        matrix = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DP 배열, 초기 값
        dp = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = matrix[n - 1][i];
        }

        System.out.println(find(0,0));


    }

    private static int find(int depth, int idx) {
        // 마지막 행이면 현재 위치의 DP 값 반환
        if (depth == n - 1) {
            return dp[depth][idx];
        }

        // 탐색하지 않았던 값이면 다음 행의 양쪽 값 비교
        if (dp[depth][idx] == null) {
            dp[depth][idx] = Math.max(find(depth + 1, idx) + matrix[depth][idx], find(depth + 1, idx + 1) + matrix[depth][idx]);
        }

        return dp[depth][idx];
    }

}
