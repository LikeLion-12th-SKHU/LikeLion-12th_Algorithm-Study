package java_2623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static List<Integer>[] graph;
	private static int[] in;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		in = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());

			for (int j = 1; j < K; j++) {
				int cur = Integer.parseInt(st.nextToken());
				graph[prev].add(cur);
				in[cur]++;
				prev = cur;
			}
		}

		topologySort();
		br.close();
	}

	private static void topologySort() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			if (in[i] == 0)
				pq.add(i);
		}

		StringBuilder sb = new StringBuilder();
		int count = 0;

		while (!pq.isEmpty()) {
			int cur = pq.poll();
			sb.append(cur).append('\n');
			count++;

			for (int next : graph[cur]) {
				in[next]--;
				if (in[next] == 0)
					pq.add(next);
			}
		}

		System.out.println(count != N ? 0 : sb);
	}
}
