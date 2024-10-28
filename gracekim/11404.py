# 11404 / 플로이드 / Gold 4

import sys
input = sys.stdin.readline

INF = int(1e9)

n = int(input())
m = int(input())

bus = []

cost = [[INF for _ in range(n + 1)] for _ in range(n+1)]

for i in range(1, n + 1):
  for j in range(1, n + 1):
    if i == j:
      cost[i][j] = 0

for i in range(m):
  a, b, c = map(int, input().split())
  if cost[a][b] > c:
    cost[a][b] = c
    
    
for k in range(n + 1):
  for i in range(n + 1):
    for j in range(n + 1):
      cost[i][j] = min(cost[i][j], cost[i][k] + cost[k][j])
      
for i in range(1, n + 1):
  for j in range(1, n + 1):
    if cost[i][j] == int(1e9):
      print(0, end=" ")
    else:
      print(cost[i][j], end=" ")
    
  print()