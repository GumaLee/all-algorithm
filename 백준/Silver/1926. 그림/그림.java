import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static int[][] graph;
    public static boolean[][] visit;

    public static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visit = new boolean[n][m];


        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {

                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int biggestSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (!visit[i][j] && graph[i][j] == 1) {
                    visit[i][j] = true;
                    count++;

                    int size = bfs(new Node(i, j), graph, visit);
                    if (size > biggestSize) {
                        biggestSize = size;
                    }
                }
            }
        }

        System.out.println(count);
        System.out.println(biggestSize);
    }

    public static int bfs(Node root, int[][] graph, boolean[][] visit) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int size = 1;

        while (!q.isEmpty()) {
            Node tempNode = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = tempNode.x + dir[i][0];
                int y = tempNode.y + dir[i][1];

                if (x >= 0 && x < n && y >= 0 && y < m && !visit[x][y] && graph[x][y] == 1) {
                    visit[x][y] = true;
                    q.add(new Node(x, y));
                    size++;
                }
            }
        }

        return size;
    }
}