import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int groupWordCount = 0;

        for(int i = 0; i < N; i++) {
            int[] alphabets = new int[27];
            boolean[] visited = new boolean[27];
            boolean isGroup = true;

            String word = br.readLine();
            int beforeAlphabetIndex = (int) word.charAt(0) - 96;

            for(int j = 1; j <= word.length(); j++) {
                int alphabetIndex = (int) word.charAt(j-1) - 96;

                if(alphabets[alphabetIndex] == 0) {
                    alphabets[alphabetIndex]++;
                    beforeAlphabetIndex = alphabetIndex;
                    visited[alphabetIndex] = true;
                }
                else if(alphabetIndex == beforeAlphabetIndex) {
                    alphabets[alphabetIndex]++;
                    beforeAlphabetIndex = alphabetIndex;
                }
                else {
                    isGroup = false;
                    break;
                }
            }
            if(isGroup)
                groupWordCount++;
        }
        System.out.println(groupWordCount);
    }
}