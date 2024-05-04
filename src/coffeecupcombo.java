import java.io.*;

public class coffeecupcombo {
    int result(String s, int x) {
        int coffee = 0;
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if ( s.charAt(i) == '1') {
                counter++;
                coffee = 2;
            } else {
                if (coffee > 0) {
                    counter++;
                    coffee--;
                }
            }
        }
        return counter;
    }


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lectures = Integer.parseInt(br.readLine());
        String str = br.readLine();

        coffeecupcombo coffee = new coffeecupcombo();
        System.out.println(coffee.result(String.valueOf(str), lectures));




    }

}