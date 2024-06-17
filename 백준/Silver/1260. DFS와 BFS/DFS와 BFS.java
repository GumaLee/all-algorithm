import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<Integer> arr[];
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int V = Integer.parseInt(token.nextToken());

        arr = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int line = 0; line < M; line++) {
            token = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(token.nextToken());
            int node2 = Integer.parseInt(token.nextToken());

            arr[node1].add(node2);
            arr[node2].add(node1);
        }

        for(int i = 0; i < arr.length; i++) {
            Collections.sort(arr[i]);
        }

        dfs(V);
        sb.setLength(sb.length()-1);
        sb.append("\n");

        visited = new boolean[N+1];
        bfs(V);
        sb.setLength(sb.length()-1);

        System.out.println(sb);
    }

    public static void dfs(int startNode) {
        visited[startNode] = true;
        sb.append(startNode + " ");

        for(int index : arr[startNode]) {
            if(!visited[index]) {
                dfs(index);
            }
        }
    }

    public static void bfs(int startNode) {
        visited[startNode] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);

        while(!queue.isEmpty()) {
            int visitNode = queue.poll();
            sb.append(visitNode + " ");

            for(int i : arr[visitNode]) {
                if(!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}