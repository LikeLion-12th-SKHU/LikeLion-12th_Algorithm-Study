package java_1647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<int[]>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			graph[A].add(new int[] {B, C});
			graph[B].add(new int[] {A, C});
		}

		boolean[] visited = new boolean[N + 1];
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		pq.offer(new int[] {1, 0});

		int total = 0, max = 0;

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int node = cur[0], weight = cur[1];

			if (visited[node])
				continue;

			visited[cur[0]] = true;
			total += weight;
			max = Math.max(max, weight);

			for (int[] next : graph[node]) {
				if (!visited[next[0]]) {
					pq.offer(new int[] {next[0], next[1]});
				}
			}
		}

		System.out.println(total - max);
		br.close();
	}
}
