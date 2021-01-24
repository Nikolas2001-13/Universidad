from sys import stdin

def sym(p):
    a=0
    if len(p)==1:
        if p[0][0]>0:
            return "Symmetric."
        else:
            return "Non-symmetric."
    for i in p:
        
        if i==p[len(p)//2][::-1]:
            a+=1
        elif i==p[len(p)-1][::-1]:
            a+=1
        else:
            a+=0
    if a%2==0:
        if a==len(p)//2:
            return "Symmetric."
        else:
            return "Non-symmetric."
    elif a%2!=0:
        if a==len(p)-1:
            return "Symmetric."
        else:
            return "Non-symmetric."
    else:
        return "Non-symmetric."

def main():
    n=int(stdin.readline())
    for i in range(n):
        N,q,a=stdin.readline().strip().split()
        a=int(a)
        p=[]
        for j in range(a):
            m=[int(s) for s in stdin.readline().split()]
            p.append(m)
        print("Test #"+str(i+1)+":",sym(p))

main()
