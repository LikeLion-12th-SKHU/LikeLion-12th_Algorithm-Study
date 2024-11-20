# 15663 / N과 M(9) / Silver 2

import sys
input = sys.stdin.readline

def tracking(k):
  if(k == m): 
    for i in range(m):
      print(answer[i], end=' ')
    print()
    return

  temp = 0 
  for i in range(n):
    if not checked[i] and temp != arr[i]:
      answer[k] = arr[i]
      checked[i] = True
      temp = arr[i]
      tracking(k+1) 
      checked[i] = False

n, m = map(int, input().split()) 
checked = [False]*n
arr = list(map(int, input().split()))
arr.sort()
answer = [-1] * 10

tracking(0)