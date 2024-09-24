import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        /**
         * 초기에는 타워 높이를 Stack에 넣으려고 했지만, Stack에는 큰 크기의 타워의 인덱스를 넣어주는 느낌
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] heights = new int[N];
        int[] receivers = new int[N];
        Stack<Integer> stack = new Stack<>();

        // 탑의 높이들을 배열에 저장
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        // 스택을 이용하여 각 탑에 대한 수신 정보를 계산
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                stack.pop(); // 자신보다 작은 탑들은 신호를 받을 수 없으므로 스택에서 제거
            }
            if (!stack.isEmpty()) {
                receivers[i] = stack.peek() + 1; // 1-based index로 저장
            } else {
                receivers[i] = 0; // 수신할 탑이 없는 경우 0으로 설정
            }
            stack.push(i); // 현재 탑을 스택에 추가
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(receivers[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}