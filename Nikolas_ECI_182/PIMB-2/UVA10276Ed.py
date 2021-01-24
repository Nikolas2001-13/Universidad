from sys import stdin

def hanoi(n,a,b):
    if n==1:
        return 1
    else:
        if n%2==0:
            a+=2
            return hanoi(n-1,a,b)+a
        else:
            b+=2
            return hanoi(n-1,a,b)+b
        

def main():
    n=int(stdin.readline().strip())
    a=0
    b=2
    print(hanoi(n,a,b))

main()
