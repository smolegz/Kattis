import java.util.*;
import java.io.*;

public class joinstrings {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> words = new ArrayList<>();
        for (int i=0;i<n; i++) words.add(br.readLine());

        int[] next = new int[n+1];
        int[] tail = new int[n+1];
        for (int i = 1; i <=n; i++) {
            tail[i] = i;
        }

        int a = 1;
        int b = 1;
        for (int i = 0; i <n-1;i++) {
            String[] numbers = br.readLine().split(" ");
            a = Integer.parseInt(numbers[0]);
            b=  Integer.parseInt(numbers[1]);
            next[tail[a]] =b;
            tail[a] = tail[b];
        }

        while (a!=0) {
            writer.print(words.get(a-1));
            a = next[a];
        }

        writer.flush();
    }
}
