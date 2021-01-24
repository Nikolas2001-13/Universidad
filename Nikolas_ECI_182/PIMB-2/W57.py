from sys import stdin

def crear(m,p,q,n,A,B):
    res=[]
    for i in range(m):
        s=[]
        for j in range(n):
            s.append(0)
        res.append(s)
    mult(m,p,q,n,A,B,res)

def mult(m,p,q,n,A,B,res):
    for i in range(len(A)):
        for j in range(len(B[0])):
            for k in range(len(B)):
                res[i][j]+=A[i][k]*B[k][j]
    for i in res:
        i=[str(u) for u in i]
        print(" ".join(i))
                
    
    

def main():
    m,p=[int(i) for i in stdin.readline().strip().split(',')]
    a=[int(i) for i in stdin.readline().strip().split(',')]
    q,n=[int(i) for i in stdin.readline().strip().split(',')]
    b=[int(i) for i in stdin.readline().strip().split(',')]
    A=[]
    B=[]
    w=0
    z=0
    while w<len(a):
        m1=a[w:w+p]
        A.append(m1)
        w+=p
    while z<len(b):
        m2=b[z:z+n]
        B.append(m2)
        z+=n
    if p!=q:
        print("Impossible")
    else:
        crear(m,p,q,n,A,B)
    
    

main()
