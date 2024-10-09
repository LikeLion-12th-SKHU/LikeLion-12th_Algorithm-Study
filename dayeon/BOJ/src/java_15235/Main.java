package java_15235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayDeque<int[]> list = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int need = Integer.parseInt(st.nextToken());
            list.add(new int[] { i, need });
        }

        int time = 0;
        int[] save = new int[n];
        while (!list.isEmpty()) {
            time++;
            int[] temp = list.poll();
            int index = temp[0];
            int need = temp[1]-1;

            if (need == 0) {
                save[index] = time;
            } else {
                list.offer(new int[] {index, need});
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(save[i]);
            if (i < n-1) {
                System.out.print(" ");
            }
        }
    }
}
