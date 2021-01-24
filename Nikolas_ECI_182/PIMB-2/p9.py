from sys import stdin

def pent(n,a,b):
    if n==1:
        return 1
    else:
        print(b)
        a+=3
        b+=a
        return pent(n-1,a,b)+a
    

def main():
    n=int(stdin.readline().strip())
    a=1
    b=1
    print(pent(n,a,b))

main()
