package BOJ.src.java_5585;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());    //380
        int money = 1000 - num;
        int[] arr = {500, 100, 50, 10, 5, 1};
        int count = 0;

        for (int i: arr){
            count += money / i;
            money %= i;
        }

        System.out.println(count);
    }
}
