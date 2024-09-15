package BOJ.src.java_10813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstReadLine = br.readLine();
        String[] firstReadLineArray = firstReadLine.split(" ");

        int basketNum = Integer.parseInt(firstReadLineArray[0]);
        int changeNum = Integer.parseInt(firstReadLineArray[1]);

        Integer[] basket = new Integer[basketNum];

        for (int i = 0; i < basketNum; i++) {
            basket[i] = i + 1;
        }
        for (int i = 0; i < changeNum; i++) {
            String nextReadLine = br.readLine();
            String[] nextReadLineArray = nextReadLine.split(" ");

            int ball1 = Integer.parseInt(nextReadLineArray[0]);
            int ball2 = Integer.parseInt(nextReadLineArray[1]);

            // 교환
            int temp = basket[ball1 - 1];
            basket[ball1 - 1] = basket[ball2 -1];
            basket[ball2 - 1] = temp;
        }
        for (int printNum : basket) {
            System.out.print(printNum + " ");
        }
    }
}