# 1918 / 후위 표기식 / Gold 2

import sys 
input = sys.stdin.readline

calculate = input().rstrip()
stack = [] 
result = ''

for i in calculate:
  if i == '(':
    stack.append(i)
  elif i == ')':
    while stack and stack[-1] != '(':
      result += stack.pop()
    stack.pop()
  elif i == '*' or i == '/': # 우선순위 고려 필요없음.
    while stack and (stack[-1] == '*' or stack[-1] == '/'): # *이나 /면 pop
      result += stack.pop()
    stack.append(i)
  elif i == '+' or i == '-':
    while stack and stack[-1] != '(': 
      result += stack.pop()
    stack.append(i)
  else:
    result += i
    
while stack:
  result += stack.pop()

print(result)