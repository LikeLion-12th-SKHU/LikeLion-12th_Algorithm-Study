package java_32770;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static final Map<String, Integer> map = new HashMap<>();
	private static final List<List<Node>> graph = new ArrayList<>();
	private static int vCount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int E = Integer.parseInt(br.readLine());
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String u = st.nextToken();
			String v = st.nextToken();
			long w = Long.parseLong(st.nextToken());
			graph.get(getVertexId(u)).add(new Node(getVertexId(v), w));
		}

		int sasaId = getVertexId("sasa");
		int homeId = getVertexId("home");

		long toHome = dijkstra(sasaId, homeId);
		long toSasa = dijkstra(homeId, sasaId);

		System.out.println((toHome == Long.MAX_VALUE || toSasa == Long.MAX_VALUE) ? -1 : toHome + toSasa);
		br.close();
	}

	// 정점 이름 -> 정수 ID 변환, 새로운 정점이면 추가
	private static int getVertexId(String vertex) {
		return map.computeIfAbsent(vertex, k -> {
			graph.add(new ArrayList<>());
			return vCount++;
		});
	}

	private static long dijkstra(int start, int end) {
		long[] dist = new long[vCount];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.w));
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (cur.w > dist[cur.v])
				continue;

			for (Node next : graph.get(cur.v)) {
				long newDist = cur.w + next.w;
				if (dist[next.v] > newDist) {
					dist[next.v] = newDist;
					pq.offer(new Node(next.v, newDist));
				}
			}
		}

		return dist[end];
	}
}

class Node {
	int v;
	long w;

	Node(int v, long w) {
		this.v = v;
		this.w = w;
	}
}
