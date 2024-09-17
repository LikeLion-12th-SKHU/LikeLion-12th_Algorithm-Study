package java_1744;

import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] array;
    public static List<Integer> oneOver = new ArrayList<>();
    public static List<Integer> one = new ArrayList<>();
    public static List<Integer> zero = new ArrayList<>();
    public static List<Integer> minus = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
            if (array[i] > 1) {
                oneOver.add(array[i]);
            } else if (array[i] == 1) {
                one.add(array[i]);
            } else if (array[i] == 0) {
                zero.add(array[i]);
            } else {
                minus.add(array[i]);
            }
        }

        int result = 0;

        // oneOver
        oneOver.sort(Collections.reverseOrder());

        for (int i = 0; i < oneOver.size()-1; i += 2) {
            result += (oneOver.get(i) * oneOver.get(i+1));
        }

        if (oneOver.size() % 2 != 0) {
            result += oneOver.get(oneOver.size() - 1);
        }

        // one
        result += one.size();

        // zero & minus
        Collections.sort(minus);

        for (int i = 0; i < minus.size()-1; i += 2) {
            result += (minus.get(i) * minus.get(i+1));
        }

        if (minus.size() % 2 != 0) {
            if (zero.size() == 0) {
                result += minus.get(minus.size() - 1);
            }
        }

        System.out.println(result);
    }
}
