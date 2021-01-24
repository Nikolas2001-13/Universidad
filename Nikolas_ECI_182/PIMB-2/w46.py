from sys import stdin

def main():
    l1=int(stdin.readline().strip())
    l2=int(stdin.readline().strip())
    l3=int(stdin.readline().strip())
    if l1+l2>l3 and l2+l3>l1 and l1+l3>l2:
        if l1==l2==l3:
            r=l1+l2+l3
            print("Equilatero,","Perimetro es",r)
        elif l1==l2:
            r=(l1*l2)-l3
            print("Isosceles,","Diferencia es",r)
        elif l1==l3:
            r=(l1*l3)-l2
            print("Isosceles,","Diferencia es",r)
        elif l3==l2:
            r=(l3*l2)-l1
            print("Isosceles,","Diferencia es",r)
        else:
            if l1>l2 and l1>l3:
                print("Escaleno,","Lado mas largo es",l1)
            elif l2>l1 and l2>l3:
                print("Escaleno,","Lado mas largo es",l2)
            elif l3>l1 and l3>l2:
                print("Escaleno,","Lado mas largo es",l3)

    else:
        print("Triangulo Imposible")


main()
