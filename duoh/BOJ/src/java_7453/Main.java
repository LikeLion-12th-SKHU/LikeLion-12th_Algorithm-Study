package java_7453;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int nn;
	private static int[] AB, CD;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		int[] B = new int[n];
		int[] C = new int[n];
		int[] D = new int[n];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}

		int k = 0;
		nn = n * n;
		AB = new int[nn];
		CD = new int[nn];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				AB[k] = A[i] + B[j];
				CD[k] = C[i] + D[j];
				k++;
			}
		}

		Arrays.sort(AB);
		Arrays.sort(CD);

		System.out.println(search());
		br.close();
	}

	private static long search() {
		int i = 0, j = nn - 1;
		long cnt = 0;

		while (i < nn && j >= 0) {
			int sum = AB[i] + CD[j];

			if (sum == 0) {
				long cntAB = 1, cntCD = 1;

				while (i + 1 < nn && AB[i] == AB[i + 1]) {
					i++;
					cntAB++;
				}

				while (j - 1 >= 0 && CD[j] == CD[j - 1]) {
					j--;
					cntCD++;
				}

				cnt += cntAB * cntCD;
				i++;
				j--;
			} else if (sum < 0) {
				i++;
			} else {
				j--;
			}
		}

		return cnt;
	}
}
