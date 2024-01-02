import java.util.*;
import java.io.*;

public class janeeyre {
    static class Book {
        long t;
        String s;
        long page;

        public Book(long t, String s, long page) {
            this.t = t;
            this.s = s;
            this.page = page;
        }
        public Book(String s, long page) {
            this.t = 0;
            this.s = s;
            this.page = page;
        }
        @Override
        public String toString() {
            return this.s;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int pile = Integer.parseInt(input[0]);
        int presents = Integer.parseInt(input[1]);
        long jane = Long.parseLong(input[2]);
        long time = 0;

        PriorityQueue<Book> p = new PriorityQueue<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.s.compareTo(o2.s);
            }
        });
        PriorityQueue<Book> q = new PriorityQueue<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Long.compare(o1.t,o2.t);
            }
        });

        for (int i = 0; i < pile; i++) {
            String str = br.readLine();
            int k = str.lastIndexOf("\"");
            String title = str.substring(1,k);

            String[] arr = str.split(" ");
            Book bk = new Book(title, Long.parseLong(arr[arr.length-1]));
            p.add(bk);
        }

        for (int i = 0; i < presents; i++) {
            String str = br.readLine();
            int j = str.indexOf("\"");
            int k = str.lastIndexOf("\"");
            String title = str.substring(j+1,k);
            String[] arr = str.split(" ");
            Book bk = new Book(Long.parseLong(arr[0]),
                    title,
                    Long.parseLong(arr[arr.length -1]));
            q.add(bk);
        }

        p.add(new Book("Jane Eyre", jane));
        boolean reading = true;

        while (reading) {
            Book book = p.poll();
            time += book.page;
            //System.out.println(book.s);
            if (book.s.equals("Jane Eyre")) {
                reading = false;
                break;
            }
            Book present = q.peek();
            while (present != null && present.t <= time) {

                Book addBk = q.poll();
                p.add(addBk);
                present = q.peek();

            }
        }

        System.out.println(time);
    }
}
