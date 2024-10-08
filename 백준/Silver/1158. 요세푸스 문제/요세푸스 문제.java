import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        List<Integer> deletedArr = new ArrayList<>();
        int index = 0;

        while (!list.isEmpty()) {
            index = (index + m - 1) % list.size();
            deletedArr.add(list.remove(index));
        }

        System.out.print("<");
        for (int i = 0; i < deletedArr.size(); i++) {
            if (i == deletedArr.size() - 1) {
                System.out.print(deletedArr.get(i));
            } else {
                System.out.print(deletedArr.get(i) + ", ");
            }
        }
        System.out.println(">");
    }
}