# 11055 / 가장 큰 증가하는 부분 수열 / Silver 2

import sys 
input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))

dp = [0] * n
dp[0] = a[0]

for i in range(1, n):
  for j in range(i):
    if a[i] > a[j]:
      dp[i] = max(dp[i], a[i] + dp[j])
    else:
      dp[i] = max(dp[i], a[i])
      
print(max(dp))
