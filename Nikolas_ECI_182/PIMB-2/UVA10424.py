from sys import stdin

def sumar2(m):
    m=str(m)
    s=0
    for i in m:
        s+=int(i)
    if len(str(s))==1:
        return s
    else:
        return sumar2(s)
    

def sumar1(n):
    n=str(n)
    s=0
    for i in n:
        s+=int(i)
    if len(str(s))==1:
        return s
    else:
        return sumar1(s)
    

def evaluar(p,q):
    r=q/p*100
    z="{0:.2f}".format(r)
    print(z,"%")

def am(x,y):
    abc=["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
    x=x.lower()
    y=y.lower()
    n=0
    m=0
    for j in x:
        n+=abc.index(j)+1
    for j in y:
        m+=abc.index(j)+1
    p=sumar1(n)
    q=sumar2(m)
    evaluar(p,q)


def main():
    x=stdin.readline().strip()
    y=stdin.readline().strip()
    while x!="":
        am(x,y)
        x=stdin.readline().strip()
        y=stdin.readline().strip()

main()
