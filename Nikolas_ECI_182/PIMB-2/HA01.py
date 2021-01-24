from sys import stdin

def orde(r):
    r.sort()
    for i in r:
        print(i)

def main():
    n=int(stdin.readline())
    r=[]
    for i in range(n):
        x=int(stdin.readline())
        r.append(x)
    orde(r)

main()
