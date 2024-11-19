# 15656 / N과 M(7) / Silver 3

import sys 
input = sys.stdin.readline

n, m = map(int, input().split())
nums = sorted(list(map(int, input().split())))
temp = []

def dfs():
  if len(temp) == m:
    print(*temp)
    return
  for i in range(n):
    temp.append(nums[i])
    dfs()
    temp.pop()

dfs()