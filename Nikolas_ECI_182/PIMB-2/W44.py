from sys import stdin
from math import sqrt

def main():
    m=float(stdin.readline().strip())
    b=float(stdin.readline().strip())
    if m==0 or b==0:
        print("Triangulo Imposible")
    else:
        if b<0:
            b*=-1
        l=b/m
        if l<0:
            l*=-1
        area=("{0:.2f}".format((b*l)/2))


        h=sqrt(b**2+l**2)
        perimetro=("{0:.2f}".format(l+b+h))


        print("El area es:",area,"y el perimetro es:",perimetro)


        

main()
