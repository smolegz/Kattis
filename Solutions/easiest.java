import java.util.*;
import java.io.*;
public class easiest {
    public static class FastScanner {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
    public static void main(String[] args) throws Exception{
        FastScanner sc = new FastScanner();
        while(true){
            int x= sc.nextInt();
            if(x==0)break;
            int y=10;
            while(true){
                if(checker(x)==checker(++y*x))break;
            }
            System.out.println(y);
        }
    }
    public static int checker(int cnt){
        int sum=0;
        char[] arr=Integer.toString(cnt).toCharArray();
        for(int i=0; i<arr.length;i++){
            sum+=Integer.parseInt(""+arr[i]);
        }
        return sum;
    }

}