from sys import stdin

def div(n):
    for i in range(1,n+1):
        if n%i==0:
            print(i)

def main():
    n=int(stdin.readline().strip())
    div(n)

main()
