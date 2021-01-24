from sys import stdin
import turtle

def triangulo(tortuga,l,x):
  if x==1:
    tortuga.begin_fill()
    tortuga.forward(l)
    tortuga.left(120)
    tortuga.forward(l)
    tortuga.left(120)
    tortuga.forward(l)
    tortuga.left(120)
    tortuga.end_fill()
  else:
    triangulo(tortuga,l/2,x-1)
    tortuga.forward(l/2)
    triangulo(tortuga,l/2,x-1)
    tortuga.left(120)
    tortuga.forward(l/2)
    tortuga.right(120)
    triangulo(tortuga,l/2,x-1)
    tortuga.right(120)
    tortuga.forward(l/2)
    tortuga.left(120)

def main():
  t = turtle.Turtle()
  n=int(stdin.readline())
  triangulo(t,200,n)
  
main()
