import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        public void setY(int y) {
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }
    }

    static int[][] dir = {{0,1}, {1, 0}, {-1, 0}, {0, -1}};


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        StringBuilder stringBuilder = new StringBuilder();

        token = new StringTokenizer(bufferedReader.readLine());

        int row = Integer.parseInt(token.nextToken());
        int column = Integer.parseInt(token.nextToken());

        int[][] map = new int[row][column];
        int[][] shortestDistMap = new int[row][column];

        for(int i = 0; i < row; i++) {
            Arrays.fill(shortestDistMap[i], -1);
        }

        for(int i = 0; i < row; i++) {
            token = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < column; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
                if(map[i][j] == 0)
                    shortestDistMap[i][j] = 0;
            }
        }

        Node startNode = new Node(0, 0);

        for(int rowIndex = 0; rowIndex < row; rowIndex++) {
            for(int columnIndex = 0; columnIndex < column; columnIndex++) {
                if(map[rowIndex][columnIndex] == 2) {
                    startNode.setX(rowIndex);
                    startNode.setY(columnIndex);
                }
            }
        }

        int dist = 0;
        boolean visited = true;

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(startNode);
        shortestDistMap[startNode.x][startNode.y] = 0;

        while(!nodeQueue.isEmpty()) {
            int count = nodeQueue.size();
            visited = false;

            for(int c = 0; c < count; c++) {
                Node node = nodeQueue.poll();

                for (int d = 0; d < 4; d++) {
                    int dx = node.x + dir[d][0];
                    int dy = node.y + dir[d][1];

                    if(dx >= 0 && dy >= 0 && dx < row && dy < column && map[dx][dy] == 1) {
                        map[dx][dy] = 3;
                        shortestDistMap[dx][dy] = dist + 1;
                        nodeQueue.add(new Node(dx, dy));
                        visited = true;
                    }
                }
            }
            if(visited)
                dist++;
        }

        for(int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++)
                stringBuilder.append(shortestDistMap[i][j]).append(" ");
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());;
    }
}