from sys import stdin

def pol(exp,p,a,x):
    if exp==len(p)-2:
        f=p[0]
        return f*(x**exp)
    else:
        r=p[a]
        return pol(exp+1,p,a-1,x)+r*(x**exp)
    
def mir(n):
    if n==0:
        return
    else:
        p=[float(i) for i in stdin.readline().strip().split()]
        x=p[len(p)-1]
        exp=0
        a=len(p)-2
        print("p("+str(x)+")="+str(pol(exp,p,a,x)))
        mir(n-1)
        

def main():
    n=int(stdin.readline().strip())
    mir(n)

main()
