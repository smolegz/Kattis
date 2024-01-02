import java.util.*;
import java.io.*;

public class sorttwonumbers {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int[] arr = new int[2];
        for (int i = 0; i < in.length; i++) {
            arr[i] = Integer.parseInt(in[i]);
        }
        Arrays.sort(arr);
        for (int k : arr) {
            System.out.print(k + " ");
        }
    }
}