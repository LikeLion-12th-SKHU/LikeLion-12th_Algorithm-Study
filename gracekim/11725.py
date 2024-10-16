# 11725 / 트리의 부모 찾기 / Silver 2

import sys 
from collections import deque
input = sys.stdin.readline

n = int(input())
tree = [[0] for _ in range(n + 1)]
parent = [0] * (n + 1)

for _ in range(n - 1):
  a, b = map(int, input().split())
  tree[a].append(b)
  tree[b].append(a)

parent[1] = 0
q = deque()
q.append(1)

while q:
  current = q.popleft()
  for t in tree[current]:
    if parent[t] == 0:
      parent[t] = current
      q.append(t)
      
print('\n'.join(map(str, parent[2: ])))