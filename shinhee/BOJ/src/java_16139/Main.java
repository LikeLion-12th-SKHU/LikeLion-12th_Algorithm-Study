package BOJ.src.java_16139;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int q = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while(q -- > 0) {
            st = new StringTokenizer(br.readLine());
            char findChar = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int count = 0;

            if(str.indexOf(findChar) >= 0){
                for(int i = start; i <= end; i++){
                    if(findChar == str.charAt(i)){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
