from sys import stdin

def fibo(n):
    if n==0:
        return 0
    elif n==1:
        return 1
    elif n==2:
        return 1
    else:
        return fibo(n-1)+fibo(n-2)

def main():
    n=int(stdin.readline().strip())
    print(fibo(n))

main()
