# 11722 / 가장 긴 감소하는 부분 수열 / Silver 2

import sys 
input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))


dp = [1] * n

for i in range(n):
  for j in range(i):
    if a[i] < a[j]:
      dp[i] = max(dp[i] , dp[j]+1)
      
print(max(dp))