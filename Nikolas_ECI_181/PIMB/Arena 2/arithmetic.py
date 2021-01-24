from sys import stdin

def arithmetic():
    a=int(stdin.readline().strip())
    b=int(stdin.readline().strip())
    x=a+b
    y=a-b
    z=a*b
    print(x)
    print(y)
    print(z)

arithmetic()
