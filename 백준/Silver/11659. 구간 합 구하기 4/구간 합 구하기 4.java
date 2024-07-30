import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(br.readLine());

        List<Integer> numbers = new ArrayList<>();
        int[] numbersArr = new int[N];

        while (tokenizer.hasMoreTokens()) {
            numbers.add(Integer.parseInt(tokenizer.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            if (i >= 1) {
                numbersArr[i] = numbers.get(i) + numbersArr[i-1];
                continue;
            }
            numbersArr[i] = numbers.get(i);
        }

        /*
        1 2 3 4 5
        1 3 6 10 15
         */


        for (int j = 0; j < M; j++) {
            tokenizer = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(tokenizer.nextToken()) - 1;
            int to = Integer.parseInt(tokenizer.nextToken()) - 1;

            if(from >= 1) {
                System.out.println(numbersArr[to] - numbersArr[from - 1]);
                continue;
            }
            System.out.println(numbersArr[to]);
        }
    }
}