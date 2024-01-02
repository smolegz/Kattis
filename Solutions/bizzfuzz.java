import java.io.*;
import java.util.*;

public class bizzfuzz {

    public static int lcm(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }
        int absNumber1 = Math.abs(number1);
        int absNumber2 = Math.abs(number2);
        int absHigherNumber = Math.max(absNumber1, absNumber2);
        int absLowerNumber = Math.min(absNumber1, absNumber2);
        int lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }

    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);
        int C = Integer.parseInt(input[2]);
        int D = Integer.parseInt(input[3]);
        int lc = lcm(C,D);
        //System.out.println(lc);
        long E =0 ;
        for (long i =A; i < A+lc;i++) {
            if (i %lc == 0) {
                E = i;
                break;
            }
        }
        long R = (B-E)/lc +1;
        System.out.println(R);
    }
}
