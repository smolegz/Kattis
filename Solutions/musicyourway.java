import java.util.*;
import java.io.*;

public class musicyourway {
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
    public static class Song {
        String[] arr;

        Song(String[] arr) {
            this.arr = arr;
        }

    }


    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        String s = sc.br.readLine();
        String[] atr = s.split(" ");
        PrintWriter writer = new PrintWriter(System.out);
        int n = sc.nextInt();
        Song[] songs = new Song[n];
        int count = 0;
        while (n-- >0) {
            String[] details = sc.br.readLine().split(" ");
            songs[count] = new Song(details);
            count++;
        }
        int t = sc.nextInt();
        while (t--> 0) {
            writer.println(s);
            String aa = sc.next();
            int indx = 0;
            for (int i =0;i<atr.length;i++) {
                if (aa.equals(atr[i])) {
                    indx=i;
                    break;
                }
            }
            int finalIndx = indx;
            Arrays.sort(songs, new Comparator<Song>() {
                @Override
                public int compare(Song o1, Song o2) {
                    return o1.arr[finalIndx].compareTo(o2.arr[finalIndx]);
                }
            });
            for (Song sg : songs) {
                for (int i =0;i< atr.length;i++) {
                    writer.print(sg.arr[i]+" ");
                }
                writer.println();
            }
            writer.println();
        }
        writer.flush();
    }
}
