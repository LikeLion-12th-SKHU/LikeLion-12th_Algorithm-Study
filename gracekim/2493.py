# 2493 / 탑 / Gold 5
import sys 
input = sys.stdin.readline

n = int(input()) # 탑의 수
top = list(map(int, input().split())) # 레이저 신호를 수신한 탑들의 번호

stack = []
answer = [0] * n # 레이저 신호를 못받았다면 0임

for i in range(n-1, -1, -1): # 거꾸로 탐색
  while stack and top[stack[-1]] < top[i]:
    answer[stack.pop()] = i+1
  stack.append(i)
  
print(*answer) 