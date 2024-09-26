package BOJ.src.java_1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] order = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N  ; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N];
        boolean[] full = new boolean[N];

        for (int i = 0; i < N; i++) {
            int count = order[i];
            int position = 0;

            for (int j = 0; j < N; j++) {
                if (!full[j]){
                    if (position == count){
                        result[j] = i + 1;
                        full[j] = true;
                        break;
                    }
                    position++;
                }
            }
        }
        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}
