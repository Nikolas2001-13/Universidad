from sys import stdin

def comp(r,s):
    a=1
    b=2
    c=0
    for i in s:
        m=r[c]
        L=r[a]
        H=r[b]
        if i>=L and i<=H:
            print(m)
        else:
            a+=3
            b+=3
            c+=3
        
    
        

def main():
    t=int(stdin.readline().strip())
    for i in range(t):
        r=[]
        s=[]
        d=int(stdin.readline().strip())
        for j in range(d):
            m,L,H=stdin.readline().strip().split()
            L=int(L)
            H=int(H)
            r.append(m)
            r.append(L)
            r.append(H)
        q=int(stdin.readline().strip())
        for k in range(q):
            p=int(stdin.readline().strip())
            s.append(p)
        comp(r,s)


main()
