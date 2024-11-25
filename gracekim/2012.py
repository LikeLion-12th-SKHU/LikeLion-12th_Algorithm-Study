# 2012 / 등수 매기기 / Silver 3

import sys
input = sys.stdin.readline

n = int(input())
expected = []
for _ in range(n):
    expected.append(int(input()))

expected.sort()

result = 0
for i in range(1, n+1):
    result += abs(i-expected[i-1])
print(result)