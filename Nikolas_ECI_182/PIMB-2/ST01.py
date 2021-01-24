from sys import stdin

def rec(n):
    if n==1:
        return 3
    elif n==2:
        return 7
    else:
        return 2*rec(n-1)+rec(n-2)

def main():
    n=int(stdin.readline().strip())
    print("Case #1:",rec(n))

main()
