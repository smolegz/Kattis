import java.util.*;
import java.io.*;

public class taketwostones {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");

        int k = Integer.parseInt(in[0]) % 2;
        if (k == 0) {
            System.out.println("Bob");
        } else {
            System.out.println("Alice");
        }
    }
}
