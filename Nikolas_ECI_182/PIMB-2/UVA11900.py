from sys import stdin

def boil(n,p,q,x):
    z=x[0:p]
    a=0
    y=0
    
    for j in z:
        if a==q:
            a+=0
            y+=0
        elif a+j<=q:
            a+=j
            y+=1
    return y
        
        
        

def main():
    t=int(stdin.readline().strip())
    w=1
    while t!=0:
        n,p,q=stdin.readline().strip().split()
        n=int(n)
        p=int(p)
        q=int(q)
        x=[int(i) for i in stdin.readline().strip().split()]
        print("Case "+str(w)+":",boil(n,p,q,x))
        w+=1
        t-=1

main()
