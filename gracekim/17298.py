# 17298 / 오큰수 / Gold 4

######## 맞은 코드 ########

import sys 
input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))

stack = []
answer = [-1] * n

for i in range(n):
  while stack and a[stack[-1]] < a[i]:
    ## stack.pop()은 인덱스를 저장하기 위한 용도.
    answer[stack.pop()] = a[i]
  stack.append(i)
  
print(*answer) # *넣으면 배열 [] 요거 사라져서 출력됨.

######## 틀린 코드 ########
## 시간초과 - O(N^2)
# import sys 
# input = sys.stdin.readline

# n = int(input()) # 수열의 크기
# a = list(map(int, input().split()))

# answer = []
# for i in range(len(a)):
#   temp = []
#   for j in range(i+1, len(a)):
#     if a[i] < a[j]:
#       temp.append(a[j])
    
#   if temp:
#     answer.append(temp[0])
#   else:
#     answer.append(-1)

# print(answer)
