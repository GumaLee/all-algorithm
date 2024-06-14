import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] result = new int[T];

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int[][] arr = new int[M][N];
            for(int n = 0; n < num; n++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                arr[n1][n2] = 1;
            }

            int cnt = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++) {
                    if(arr[j][i] == 1) {
                        cnt++;
                        arr[j][i] = 0;
                        Queue<Node> que = new LinkedList<>();
                        que.add(new Node(j, i));
                        while(!que.isEmpty()) {
                            Node n = que.poll();
                            for(int d = 0; d < 4; d++) {
                                int dx = n.x + dir[d][0];
                                int dy = n.y + dir[d][1];
                                if(dx >= 0 && dy >= 0 && dx < M && dy < N && arr[dx][dy] == 1) {
                                    arr[dx][dy] = 0;
                                    que.add(new Node(dx, dy));
                                }
                            }
                        }
                    }
                }
            }
            result[t] = cnt;
        }
        for(int i = 0; i < T; i++)
            System.out.println(result[i]);
    }
}