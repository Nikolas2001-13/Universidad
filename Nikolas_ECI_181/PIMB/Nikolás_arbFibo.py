from sys import stdin
import turtle

def fibo(t,l):
  if l==0:
    t.forward(0)
  elif l==1:
    t.forward(25)
  elif l > 1:
    t.forward(25)
    t.right(20)
    fibo(t,(l-1)+(l-2))
    t.left(40)
    fibo(t,(l-1)+(l-2))
    t.right(20)
    t.backward(25)
    
  

def main():
  t = turtle.Turtle()
  t.left(45)
  x=int(stdin.readline())
  fibo(t,x)
  
main()
