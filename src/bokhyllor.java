import java.util.*;
import java.io.*;

public class bokhyllor {
    public static class Pair implements Comparable<Pair>{
        int h;
        int l;

        Pair(int a, int b) {
            this.h = a;
            this.l= b;
        }

        public int compareTo(Pair o1) {
            if (this.h == o1.h) {
                return this.l - o1.l;
            } else {
                return this.h - o1.h;
            }
        }
    }
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
    static Pair[][][] mem = new Pair[21][21][21];

    public static Pair result(int s, int m, int b, int w) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Pair toAdd;
        if (s == 0 && m == 0 && b ==0) {
            return new Pair(1,0);
        }
        if (mem[s][m][b] != null) {
            //System.out.println("Reading: " +s + " " + m + " " + b);
            //System.out.println(mem[s][m][b].h);
            return mem[s][m][b];
        }

        if (s == 0) {
            if (m > 0 && b >0) {
                Pair q = result(s,m-1,b,w);
                if (w-q.l >= 2) {
                    q.l += 2;
                } else {
                    q.h +=1;
                    q.l = 2;
                }

                Pair r = result(s,m,b-1,w);
                if (w-r.l >= 3) {
                    r.l += 3;
                } else {
                    r.h +=1;
                    r.l = 3;
                }
                pq.add(q);
                pq.add(r);
                toAdd = pq.poll();
                //System.out.println("Writing: " + s + " "+ m + " " +b);
                mem[s][m][b] = new Pair(toAdd.h, toAdd.l);
                return toAdd;
            }
            if (m > 0) {

                Pair q = result(s,m-1,b,w);
                if (w-q.l >= 2) {
                    q.l += 2;
                } else {
                    q.h +=1;
                    q.l = 2;
                }
                //System.out.println("Writing: " + s + " "+ m + " " +b);
                mem[s][m][b] = new Pair(q.h, q.l);
                return q;
            } else {
                //System.out.println("Here: " + s + " "+ m + " " +b);
                Pair r = result(s,m,b-1,w);
                //System.out.println("Here " + r.h);
                if (w-r.l >= 3) {
                    r.l += 3;
                } else {
                    r.h +=1;
                    r.l = 3;
                }
                //System.out.println("Writing: " + s + " "+ m + " " +b);
                //System.out.println("Height is: " + r.h);
                mem[s][m][b] = new Pair(r.h, r.l);;
                return r;
            }
        }

        if (m == 0) {
            if (b > 0) {
                Pair p = result(s-1,m,b,w);
                //System.out.println("P: " + p.h + " " + p.l);
                if (w-p.l >= 1) {
                    p.l += 1;
                } else {
                    p.h +=1;
                    p.l = 1;
                }
                Pair r = result(s,m,b-1,w);
                if (w-r.l >= 3) {
                    r.l += 3;
                } else {
                    r.h +=1;
                    r.l = 3;
                }
                pq.add(p); pq.add(r);
                toAdd = pq.poll();
                //System.out.println("Writing: " + s + " "+ m + " " +b);
                mem[s][m][b] = new Pair(toAdd.h, toAdd.l);;
                return toAdd;
            } else {
                Pair p = result(s-1,m,b,w);
                if (w-p.l >= 1) {
                    p.l += 1;
                } else {
                    p.h +=1;
                    p.l = 1;
                }
                //System.out.println("Writing: " + s + " "+ m + " " +b);
                mem[s][m][b] = new Pair(p.h, p.l);;
                return p;
            }
        }

        if (b == 0) {
            Pair p = result(s-1,m,b,w);
            if (w-p.l >= 1) {
                p.l += 1;
            } else {
                p.h +=1;
                p.l = 1;
            }
            Pair q = result(s,m-1,b,w);
            if (w-q.l >= 2) {
                q.l += 2;
            } else {
                q.h +=1;
                q.l = 2;
            }
            pq.add(p); pq.add(q);
            toAdd = pq.poll();
            //System.out.println("Writing: " + s + " "+ m + " " +b);
            mem[s][m][b] = new Pair(toAdd.h, toAdd.l);;
            return toAdd;
        }

        Pair p = result(s-1,m,b,w);
        if (w-p.l >= 1) {
            p.l += 1;
        } else {
            p.h +=1;
            p.l = 1;
        }
        Pair q = result(s,m-1,b,w);
        if (w-q.l >= 2) {
            q.l += 2;
        } else {
            q.h +=1;
            q.l = 2;
        }
        Pair r = result(s,m,b-1,w);
        if (w-r.l >= 3) {
            r.l += 3;
        } else {
            r.h +=1;
            r.l = 3;
        }

        pq.add(p);
        pq.add(q);
        pq.add(r);
        toAdd = pq.poll();
        //System.out.println("Writing: " + s + " "+ m + " " +b);
        mem[s][m][b] = new Pair(toAdd.h, toAdd.l);;
        return toAdd;

    }


    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        int[] arr = sc.readArray(3);
        int width = sc.nextInt();
        Pair r = result(arr[0], arr[1], arr[2], width);

        System.out.println(r.h);


    }
}
