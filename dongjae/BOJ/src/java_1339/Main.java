package java_1339;

import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static String[] words;
    public static int[] alphaWeights = new int[26];
    public static List<Integer> weights = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            for (int j = 0; j < words[i].length(); j++) {
                char now = words[i].charAt(j);
                alphaWeights[(int)(now - 'A')] += (int) Math.pow(10, words[i].length() - 1 - j);
            }
        }

        for (int i = 0; i < alphaWeights.length; i++) {
            if (alphaWeights[i] > 0) {
                weights.add(alphaWeights[i]);
            }
        }

        weights.sort(Collections.reverseOrder());

        int result = 0;
        int num = 9;
        for (int weight : weights) {
            result += weight * num--;
        }

        System.out.println(result);
    }
}