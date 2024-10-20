# 4963 / 섬의 개수 / Silver 2

from collections import deque
import sys
input = sys.stdin.readline

def bfs(x, y):
  # 방향: 오른쪽, 왼쪽, 위쪽, 아래쪽, 
  # 오른쪽 위 대각, 왼쪽 아래 대각, 오른쪽 아래 대각, 왼쪽 위 대각
  dx = [1, -1, 0, 0, 1, -1, 1, -1] 
  dy = [0, 0, -1, 1, -1, 1, 1, -1]
  q = deque()
  q.append([x, y])
  while q:
    a, b = q.popleft()
    for i in range(8):
      nx = a + dx[i]
      ny = b + dy[i]
      if 0 <= nx < h and 0 <= ny < w and field[nx][ny] == 1:
        field[nx][ny] = 0
        q.append([nx, ny])

while True:
  w, h = map(int, input().split())
  if w == 0 and h == 0:
    break
  field = []
  cnt = 0
  for _ in range(h):
    field.append(list(map(int, input().split())))
  for i in range(h):
    for j in range(w):
      if field[i][j] == 1:
          bfs(i, j)
          cnt += 1
          
  print(cnt)