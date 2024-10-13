# 16401 / 과자 나눠주기 / Silver 2

import sys 
input = sys.stdin.readline

m, n = map(int, input().split())
cookie = list(map(int, input().split()))

start = 1
end = max(cookie)

result = 0 

while start <= end:
  mid = (start + end) // 2
  
  count = 0
  for c in cookie: 
    if c < mid:
      continue
    else: 
      count += c//mid
      
  if count >= m:
    start = mid + 1
    result = max(result, mid)
  else:
    end = mid - 1
    
print(result)

