import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        /**
         * 핵심은 우리가 계산하듯이 괄호 안의 계산을 먼저 수행하는 것이 아니라
         * 분배법칙을 사용해서 다 따로 계산을 수행하고 더하는 것이라고 보면 되겠다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;
        int value = 1;


        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(input.charAt(i));
                value *= 2;
                continue;
            }

            if (input.charAt(i) == '[') {
                stack.push(input.charAt(i));
                value *= 3;
                continue;
            }

            if (input.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }
                if (input.charAt(i - 1) == '(') {
                    result += value;
                }
                stack.pop();
                value /= 2;
                continue;
            }

            if (input.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }
                if (input.charAt(i - 1) == '[') {
                    result += value;
                }
                stack.pop();
                value /= 3;
            }
        }

        if (!stack.isEmpty()) {
            result = 0;
        }

        System.out.println(result);
    }
}