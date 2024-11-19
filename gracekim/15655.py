# 15655 / N과 M(6) / Silver 3

import sys
input = sys.stdin.readline

n, m = map(int, input().split())
numbers = sorted(list(map(int,input().split())))

result = []

def back(s):
  if len(result) == m:
    print(*result)
    return

  for i in range(s, n):
    result.append(numbers[i])
    back(i+1)
    result.pop()

back(0)
