package BOJ.src.java_10610;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        String[] arr = num.split("");

        Arrays.sort(arr, Collections.reverseOrder());

        long sum = 0;
        String result = "-1";
        StringBuilder sb = new StringBuilder();

        if (num.contains("0")){
            for(String i : arr){
                sum += Long.parseLong(i);
            }
            if (sum % 3 == 0){
                for (String i: arr){
                    sb.append(i);
                }
                result = sb.toString();
            }
        }
        System.out.println(result);
    }
}
