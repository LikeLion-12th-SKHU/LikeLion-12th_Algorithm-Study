package java_32141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(battle(cards, H));
    }
    private static int battle(int[] cards, int H) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < cards.length; i++) {
            if (sum + cards[i] < H) {
                sum += cards[i];
                count++;
            } else {
                count++;
                return count;
            }
        }
        return -1;
    }
}
