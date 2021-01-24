from sys import stdin

def sec(n,a,b):
    for i in range(n):
        if a==2:
            print(str(a)*b)
        else:
            b*=2
            print(str(a)*b)
        a+=2

def main():
    n=int(stdin.readline().strip())
    a=2
    b=1
    sec(n,a,b)

main()
