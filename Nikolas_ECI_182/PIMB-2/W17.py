from sys import stdin

def crear(n):
    m=[]
    for i in range(n):
        s=[]
        for j in range(n):
            s.append(1)
        m.append(s)
    mod(m,n)
def mod(m,n):
    j=1
    k=1
    p=2
    c=2
    while j<=n/2:
        for q in range(n-p):
            m[j][k:n-k]=[c for n in m[j][k:n-k]]
            j+=1
        k+=1
        j=k
        c+=1
        p+=2
    res(m)
def res(m):
    for i in m:
        i=str(i)
        i=i.replace(" ","")
        print(i)

def main():
    n=int(stdin.readline().strip())
    crear(n)

main()
    
