from sys import stdin

def mult(a,b):
    if a==0 or b==0:
        return 0
    elif a>0 and b>0:
        return (a+mult(a,b-1))

def mir(n):
    if n==0:
        return
    else:
        a,b=stdin.readline().strip().split()
        a=int(a)
        b=int(b)
        print(mult(a,b))
        mir(n-1)
        

def main():
    n=int(stdin.readline().strip())
    mir(n)

main()
