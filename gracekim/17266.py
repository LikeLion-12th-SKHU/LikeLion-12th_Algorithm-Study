# 17266 / 어두운 굴다리 / Silver 4

import sys 
input = sys.stdin.readline

n = int(input()) # 굴다리의 길이
m = int(input()) # 가로등의 개수

streetlight = list(map(int, input().split()))

def canLight(h):
  prev = 0
  for s in streetlight:
    if s - h <= prev:
      prev = s + h
    else:
      return False
  return prev >= n


start = 1
end = n
result = 1

while start <= end:
  mid = (start + end) // 2
  if canLight(mid):
    end = mid - 1
    result = mid
  else:
    start = mid + 1
    
print(result)