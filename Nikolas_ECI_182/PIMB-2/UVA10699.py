from sys import stdin

def prim(n):
    a=2
    r=[]
    while n!=1:
            if n%a==0:
                if a not in r:
                    r.append(a)
                n=n/a
            else:
                a=a+1
    y=len(r)
    return y

def main():
    n=int(stdin.readline())
    while n!=0:
        print(n,":",prim(n))
        n=int(stdin.readline())

main()
