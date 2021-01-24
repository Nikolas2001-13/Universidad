from sys import stdin

def vecinos(f,e,d):
    fir=f**2+e**2
    res=fir**(1/2)
    if res<d:
        print("Vecinos")
    else:
        print("No Vecinos")

def main():
    h1,k1,r1=stdin.readline().strip().split()
    h2,k2,r2=stdin.readline().strip().split()
    h1=float(h1)
    k1=float(k1)
    r1=float(r1)
    h2=float(h2)
    k2=float(k2)
    r2=float(r2)
    f=h1-h2
    e=k1-k2
    d=r1+r2
    vecinos(f,e,d)


main()
    
