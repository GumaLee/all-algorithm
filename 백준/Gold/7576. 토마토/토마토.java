import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer token;

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] dir = {{0,1}, {1,0}, {-1,0}, {0,-1}};

    public static void main(String[] args) throws IOException {

        int[] mapSize = MapSizeInput();
        int row = mapSize[0];
        int column = mapSize[1];

        int[][] map = makeMap(row, column);
        List<Node> startNodeList = findStartNode(map);
        
        if (checkMap(map) != -1) {
            System.out.println(0);
            System.exit(0);
        }

        int result = tomatoBfs(map, startNodeList);
        System.out.println(result);
//        for(Node startNode : startNodeList)
//            System.out.println(startNode.x + " " + startNode.y + "\n");
//        showMap(map, row, column);

    }

    private static int[] MapSizeInput() throws IOException{
        token = new StringTokenizer(bufferedReader.readLine());

        int column = Integer.parseInt(token.nextToken());
        int row = Integer.parseInt(token.nextToken());
        int[] mapSize = new int[2];

        mapSize[0] = row;
        mapSize[1] = column;

        return mapSize;
    }

    private static int[][] makeMap(int row, int column) throws IOException{
        int[][] map = new int[row][column];

        for(int i = 0; i < row; i++) {
            token = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < column; j++)
                map[i][j] = Integer.parseInt(token.nextToken());
        }

        return map;
    }

    private static void showMap(int[][] map, int row, int column) {
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }

    public static int[][] twoArrayDeepCopy(int[][] arr) {
        int[][] copiedArr = new int[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++) {
            copiedArr[i] = arr[i].clone();
        }
        return copiedArr;
    }

    public static List<Node> findStartNode(int map[][]) {
        List<Node> startNodeList = new ArrayList<>();
        int row = map.length;
        int column = map[0].length;

        for(int rowIndex = 0; rowIndex < row; rowIndex++) {
            for(int columnIndex = 0; columnIndex < column; columnIndex++) {
                if(map[rowIndex][columnIndex] == 1)
                    startNodeList.add(new Node(rowIndex, columnIndex));
            }
        }
        return startNodeList;
    }

    public static int checkMap(int map[][]) {
        for(int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 0)
                    return -1;
            }
        }
        return 0;
    }

    private static int tomatoBfs(int[][] map, List<Node> startNodeList) {
        int[][] tempMap = twoArrayDeepCopy(map);
        int row = map.length;
        int column = map[0].length;

        int date = 0;

        Queue<Node> nodeQueue = new LinkedList<>();
        for (Node node : startNodeList) {
            nodeQueue.add(node);
            tempMap[node.x][node.y] = 1;
        }

        while(!nodeQueue.isEmpty()) {
            date++;
            int count = nodeQueue.size();

            for(int c = 0; c < count; c++) {
                Node node = nodeQueue.poll();

                for (int d = 0; d < 4; d++) {
                    int dx = node.x + dir[d][0];
                    int dy = node.y + dir[d][1];

                    if(dx >= 0 && dy >= 0 && dx < row && dy < column && tempMap[dx][dy] == 0) {
                        tempMap[dx][dy] = 1;
                        nodeQueue.add(new Node(dx, dy));
                    }
                }
            }
        }

        if (checkMap(tempMap) == -1)
            return -1;
        else
            return date-1;
    }
}