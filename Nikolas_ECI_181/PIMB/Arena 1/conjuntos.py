from sys import stdin

x=(stdin.readline().strip())
y=(stdin.readline().strip())
z=(stdin.readline().strip())
op=(stdin.readline().strip())
v=int(stdin.readline().strip())

def C1():
    a,b=x.split()
    c1=range(int(a),(int(b)+1))
    list_c1= list(c1)
    s=set(list_c1)
    return(s)
def C2():
    p,q=y.split()
    c2=range(int(p),(int(q)+1))
    list_c2= list(c2)
    s=set(list_c2)
    return(s)
def C3():
    r,s=z.split()
    c3=range(int(r),(int(s)+1))
    list_c3= list(c3)
    s=set(list_c3)
    return(s)

if op=="u":
    u=C1()|C2()|C3()
    if v in u:
        print("Pertenece")
    else:
        print("No pertenece")
elif op=="n":
    n=C1()&C2()&C3()
    if v in n:
        print("Pertenece")
    else:
        print("No pertenece")
if op=="d":
    d=(C1()-C2())-C3()
    if v in d:
        print("Pertenece")
    else:
        print("No pertenece")

    
