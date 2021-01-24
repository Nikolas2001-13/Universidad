from sys import stdin

def fibo(x):
    if x==0:
        return 0
    elif x==1:
        return 1
    elif x>0:
        return fibo(x-1)+fibo(x-2)

def main():
    n=int(stdin.readline().strip())
    z=fibo(n)
    print (z)

main()
    
