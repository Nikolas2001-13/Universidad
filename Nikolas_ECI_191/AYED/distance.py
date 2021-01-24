from sys import stdin

def back(n,h,res,i):
    if i==n:
        t=res.count("1")
        if t==h:
            print(res)
    else:
        for x in range(0,2):
            res=res+str(x)
            back(n,h,res,i+1)
            res=res[:-1]

def main():
    a=int(stdin.readline().strip())
    for k in range(a):
        stdin.readline()
        n,h=[int(s) for s in stdin.readline().strip().split()]
        res=""
        i=0
        back(n,h,res,i)
        if k+1<a:
            print("")
        

main()
