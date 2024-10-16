# 7795 / 먹을 것인가 먹힐 것인가 / Silver 3

# import sys 
# input = sys.stdin.readline

# t = int(input()) # 테스트 케이스 개수

# for _ in range(t):
#   n, m = map(int, input().split()) # a의 수, b의 수
#   a = list(map(int, input().split()))
#   b = list(map(int, input().split()))
#   cnt = 0
#   for i in a:
#     for j in b:
#       if i > j:
#         cnt += 1

#   print(cnt)

import sys 
input = sys.stdin.readline

t = int(input()) # 테스트 케이스 개수

for _ in range(t):
  n, m = map(int, input().split()) # a의 수, b의 수
  a = list(map(int, input().split()))
  b = list(map(int, input().split()))
  a.sort()
  b.sort()
  
  start = 0
  cnt = 0
  for i in range(n):
    while True:
      if start == m or a[i] <= b[start]:
        cnt += start
        break
      else:
        start += 1

  print(cnt)