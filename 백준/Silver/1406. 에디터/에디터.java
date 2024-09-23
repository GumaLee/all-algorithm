import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();
        LinkedList<Character> list = new LinkedList<>();
        for (char ch : input.toCharArray()) {
            list.add(ch);
        }

        ListIterator<Character> iterator = list.listIterator(list.size());

        int M = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < M; i++) {
            String command = bufferedReader.readLine();
            char operation = command.charAt(0);

            switch (operation) {
                case 'P':
                    char toInsert = command.charAt(2);
                    iterator.add(toInsert);
                    break;

                case 'L':
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                    }
                    break;

                case 'D':
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                    break;

                case 'B':
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch : list) {
            result.append(ch);
        }

        System.out.println(result.toString());
    }
}