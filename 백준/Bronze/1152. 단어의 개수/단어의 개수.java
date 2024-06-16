import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1152번 : https://www.acmicpc.net/problem/1152
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int wordCnt = 0;
        while(st.hasMoreTokens()) {
            st.nextToken();
            wordCnt++;
        }

        System.out.println(wordCnt);
    }
}