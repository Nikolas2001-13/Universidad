from sys import stdin

def estampillas(n):
    if n==1:
        return 3
    else:
        return estampillas(n-1)+estampillas(n-1)*2+10

def main():
    n=int(stdin.readline().strip())
    print(estampillas(n),"estampillas")

main()
