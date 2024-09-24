import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 괄호의 시작과 끝은 막대기의 시작과 끝 : 단 괄호 사이에 다른 괄호가 있는 경우만
         * 하나의 완성된 괄호 사이에 다른 괄호가 없다면 그 괄호 사이에 레이저가 존재한다.
         * 잘려진 막대의 개수는?
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();

        int result = 0;
        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push('(');
                continue;
            }

            if (input.charAt(i) == ')') {
                stack.pop();

                if (input.charAt(i - 1) == '(') {
                    result += stack.size();
                } else {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}