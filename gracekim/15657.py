# 15657 / N과 M(8) / Silver 3

import sys 
input = sys.stdin.readline

n, m = map(int, input().split())
numbers = sorted(list(map(int, input().split())))
temp = []

def dfs(start):
  if len(temp) == m:
    print(*temp)
    return
  
  for i in range(start, n):
    temp.append(numbers[i])
    dfs(i)
    temp.pop()
    
    
dfs(0)