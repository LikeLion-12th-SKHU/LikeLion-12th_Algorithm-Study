package java_2161;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        boolean turn = true;
        Queue<Integer> floor = new LinkedList<>();
        while (queue.size() != 1) {
            if (turn) {
                floor.offer(queue.poll());
            } else {
                queue.offer(queue.poll());
            }
            turn = !turn;
        }
        while (!floor.isEmpty()) {
            System.out.print(floor.poll() + " ");
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}