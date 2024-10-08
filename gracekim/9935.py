# 9935 / 문자열 폭발 / Gold 4
######## 맞은 코드 ########
import sys 
input = sys.stdin.readline

s = input().rstrip()
explosion = input().rstrip()

stack = []
explosion_len = len(explosion)

for i in range(len(s)):
  stack.append(s[i])
  ## 폭발 문자열의 글자수 만큼 슬라이싱해서, 스택에 들어간 문자들을 문자열로 만든 후, explosion과 일치하는지 확인
  if ''.join(stack[-explosion_len:]) == explosion:
    for _ in range(explosion_len):
      stack.pop()
  
if stack:
  print(''.join(stack))
else:
  print('FRULA')


######## 틀린 코드 ########
## 시간초과 - O(N^2)
# import sys 
# input = sys.stdin.readline

# s = input().rstrip()
# explosion = input().rstrip()

# while explosion in s:
#   s = s.replace(explosion, '') 
  
# if s:
#   print(s)
# else:
#   print("FRULA")