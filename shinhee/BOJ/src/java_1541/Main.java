package BOJ.src.java_1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int sum = Integer.MAX_VALUE;    // 초기 상태 여부 확인을 위한 값

        while(st.hasMoreTokens()){
            int temp = 0;

            StringTokenizer newst = new StringTokenizer(st.nextToken(), "+");

            while(newst.hasMoreTokens()){
                temp += Integer.parseInt(newst.nextToken());
            }

            if (sum == Integer.MAX_VALUE){
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);


    }
}
