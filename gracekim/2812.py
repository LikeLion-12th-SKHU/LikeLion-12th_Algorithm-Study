# 2812 / 크게 만들기 / Gold 3

import sys 
input = sys.stdin.readline

n, k = map(int, input().split())
num = list(input().rstrip())

stack = []

for i in range(n):
  # k 휫수가 사라질 때 까지만 앞뒤 숫자 비교하면 됨.
  while k > 0 and stack and stack[-1] < num[i]:
    stack.pop()
    k -= 1
  stack.append(num[i])

if k >= 0:
  print(''.join(stack[:len(stack) - k]))
  
else:
  print(''.join(stack[:]))