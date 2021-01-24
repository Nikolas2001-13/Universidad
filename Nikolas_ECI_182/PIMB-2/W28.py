from sys import stdin

def rev(n,long,r):
    if long==0:
        b=n[0]
        r.append(b)
        return r
    else:
        b=n.pop(long)
        r.append(b)
        return rev(n,long-1,r)
    

def main():
    n=str(stdin.readline().strip())
    if n=="":
        return 
    else:
        n=list(n)
        long=len(n)-1
        r=[]
        s=rev(n,long,r)
        print("".join(s))
        main()

main()

