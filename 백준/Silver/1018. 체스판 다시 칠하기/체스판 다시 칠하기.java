import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 체스판 경우의 수를 모두 만든다.
        // 2. 각각의 체스판을 검사해 필요한 수정 횟수를 반환한다.

        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();

        String[] board = new String[row];
        for(int i = 0; i < row; i++) {
            board[i] = sc.nextLine();
        }

        // 체스판 자르기
        int finalCost = Integer.MAX_VALUE;

        for(int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= col - 8; j++) {
                // 해당(현재) 체스판의 최소비용 구하기
                int culCost = getSolution(i, j, board);

                // 전체 최적의 값과 비교하여 갱신하기
                if (culCost < finalCost) finalCost = culCost;
            }
        }

        System.out.println(finalCost);
        sc.close();
    }

    private static int getSolution(int startRow, int startCol, String[] board) {
        String[] answerSheet = {"WBWBWBWB", "BWBWBWBW"};
        int whiteSolCount = 0;

        for (int i = 0; i < 8; i++) {
            int curRow = startRow + i;
            for (int j = 0; j < 8; j++) {
                int curCol = startCol + j;
                if (board[curRow].charAt(curCol) != answerSheet[curRow % 2].charAt(j)) whiteSolCount++;
            }
        }

        return Math.min(whiteSolCount, 64 - whiteSolCount);
    }
}
