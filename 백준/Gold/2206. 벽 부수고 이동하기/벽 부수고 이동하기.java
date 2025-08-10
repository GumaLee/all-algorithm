import java.util.*;
import java.io.*;

public class Main {

    static int[][] metrics;
    static boolean[][][] visited;
    static int wallBreakChance = 1;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static class Node {
        int x;
        int y;
        int broke;
        int dist;

        Node(int x, int y, int broke, int dist) {
            this.x = x;
            this.y = y;
            this.broke = broke;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 방문 체크용을 두개를 만들어서 하나는 벽을 부수지 않고 지나가는 방문체크용, 다른 하나는 벽을 한번 부순 적이 있을 떄 방문체크용
        metrics = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < M; j++) {
                metrics[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(metrics, visited));
    }

    public static int bfs(int[][] metrics, boolean[][][] visited) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, 0, 1));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node curNode = q.poll();

            // 도착하면 즉시 반환(현재까지 거리)
            if (curNode.x == metrics.length - 1 && curNode.y == metrics[0].length - 1) return curNode.dist;


            for (int i = 0; i < 4; i++) {
                int dx = curNode.x + dir[i][0];
                int dy = curNode.y + dir[i][1];

                if (dx < 0 || dy < 0 || dx >= metrics.length || dy >= metrics[0].length) continue;

                // 벽 X
                if (metrics[dx][dy] == 0 && !visited[dx][dy][curNode.broke]) {
                    visited[dx][dy][curNode.broke] = true;
                    q.add(new Node(dx, dy, curNode.broke, curNode.dist + 1));
                }
                // 벽이면 아직 안부쉈을 때만 부수고 이동
                else if (metrics[dx][dy] == 1 && curNode.broke == 0 && !visited[dx][dy][1]) {
                    visited[dx][dy][1] = true;
                    q.add(new Node(dx, dy, 1, curNode.dist + 1));
                }
            }
        }
        return -1;
    }
}
