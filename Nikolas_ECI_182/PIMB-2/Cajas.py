from sys import stdin

def quick(a):
    if len(a)<=1:
        return a
    else:
        piv=a[len(a)//2]
        igual=[i for i in a if i==piv]
        menor=[i for i in a if i<piv]
        mayor=[i for i in a if i>piv]
        return quick(menor)+igual+quick(mayor)

def orde(r):
    w=[]
    for i in r:
        if int(2) in i:
            p=i.index(2)
            h=i[0:p]
            s=i[p:]
            u=quick(h)
            q=u+s
            w.append(q)
        else:
            z=quick(i)
            w.append(z)
    for i in w:
        i=str(i)
        i=i.replace(",","")
        i=i.replace("[","")
        i=i.replace("]","")
        print(i)
                       

def main():
    m,n=[int(i) for i in stdin.readline().split()]
    r=[]
    for i in range(m):
        x=[int(j) for j in stdin.readline().split()]
        r.append(x)
    orde(r)

main()
