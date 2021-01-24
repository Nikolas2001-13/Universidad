from sys import stdin

def tren(n,m,r):
    p=0
    q=n*m
    for i in r:
        a=i[1]
        b=i[2]
        if a==b:
            z=1
        else:
            z=b-a+1
        p+=z
    res=q-p
    print(res)

def main():
    n,m,k=stdin.readline().strip().split()
    n=int(n)
    m=int(m)
    k=int(k)
    r=[]
    for i in range(k):
        x=[int(j) for j in stdin.readline().split()]
        r.append(x)
        
    tren(n,m,r)

main()
