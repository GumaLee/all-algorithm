import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static int M;
    public static int[] baseArr;
    public static int[] arr;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        baseArr = new int[N];
        arr = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            baseArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(baseArr);

        backTracking(0);
        System.out.println(sb);
    }

    public static void backTracking(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = baseArr[i];
                backTracking(depth + 1);
                visited[i] = false; // backtracking
            }
        }
    }
}