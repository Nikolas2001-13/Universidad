from sys import stdin
import math

m=float(stdin.readline().strip())
b=float(stdin.readline().strip())


if m!=0 and b!=0: 
    x=(-b/m)
    y=math.sqrt(b**2)
    z=math.sqrt(x**2)
    area=("{0:.2f}".format(y*z/2))
    h=(math.sqrt(x**2+b**2))
    perimetro=("{0:.2f}".format(y+z+h))
    print("El area es:",area,"y el perimetro es:",perimetro)

elif m==0 or b==0:
    print("Triangulo Imposible")
