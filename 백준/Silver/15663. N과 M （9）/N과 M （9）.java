import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N;
    public static int M;

    public static int[] baseArr;
    public static int[] arr;
    public static boolean[] visited;
    public static Set<String> set = new LinkedHashSet<>();

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
        set.forEach(System.out::println);
    }

    public static void backTracking(int depth) {
        if (depth == M) {
            String temp = "";
            for (int value : arr) {
                temp += value + " ";
            }
            set.add(temp);
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