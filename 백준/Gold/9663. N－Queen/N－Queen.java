import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] chess;
    static int N, cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 인덱스 = 열, 값 = 행
        chess = new int[N];
        cnt = 0;

        // 하나의 열과 행에 Queen은 하나 밖에 올 수 없다. -> 이것 때문에 무조건 N 개가 놓이게 되겠네!!
        // 앞에 놓은 모든 Queen들의 행 또는 열이 나와 같지 않아야 함.
        // 앞에 놓은 모든 Queen들과 대각선 상에 위치하지 않아야 함 -> 열의 차이 == 행의 차이

        dfs(0);
        System.out.println(cnt);
    }

    private static void dfs(int col) {
        if (col == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            // (i 행, col 열)에 N이 위치할 때
            chess[col] = i;

            if(check(col)) {
                dfs(col + 1);
            }
        }
    }

    private static boolean check(int col) {
        // col 까지만 확인하면 된다. 순서대로 진행하고 있으므로, 본인보다 작은 행, 열 내에서만 조건을 검증하면 되기 때문.
        for (int i = 0; i < col; i++) {
            // 같은 행에 다른 Queen이 존재하는가?
            if (chess[col] == chess[i]) {
                return false;
            }

            // 같은 열에 대해서는 볼 필요가 없다. 이미 하나의 열을 인덱스로 설정하고 진행하고 있기 때문.
            if (col - i == Math.abs(chess[col] - chess[i]))
                return false;
        }
        return true;
    }
}