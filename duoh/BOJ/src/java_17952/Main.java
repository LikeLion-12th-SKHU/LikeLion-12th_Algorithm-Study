package java_17952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        ArrayDeque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                stack.push(new int[] {score, time});
            }

            if (!stack.isEmpty()){
                int[] task = stack.pop();

                if (task[1] == 1) {
                    answer += task[0];
                } else {
                    task[1]--;
                    stack.push(task);
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}
