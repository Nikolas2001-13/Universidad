from sys import stdin

def comparar(a1,a2,a3,b1,b2,b3):
    A=0
    B=0
    if a1>b1:
        A+=1
        if a2>b2:
            A+=1
            if a3>b3:
                A+=1
            elif b3>a3:
                B+=1
            elif a3==b3:
                A+=0
        elif b2>a2:
            B+=1
            if a3>b3:
                A+=1
            elif b3>a3:
                B+=1
            elif a3==b3:
                A+=0
        elif a2==b2:
            A+=0
            if a3>b3:
                A+=1
            elif b3>a3:
                B+=1
            elif a3==b3:
                A+=0
    elif b1>a1:
        B+=1
        if a2>b2:
            A+=1
            if a3>b3:
                A+=1
            elif b3>a3:
                B+=1
            elif a3==b3:
                A+=0
        elif b2>a2:
            B+=1
            if a3>b3:
                A+=1
            elif b3>a3:
                B+=1
            elif a3==b3:
                A+=0
        elif a2==b2:
            A+=0
            if a3>b3:
                A+=1
            elif b3>a3:
                B+=1
            elif a3==b3:
                A+=0
    elif a1==b1:
        A+=0
        if a2>b2:
            A+=1
            if a3>b3:
                A+=1
            elif b3>a3:
                B+=1
            elif a3==b3:
                A+=0
        elif b2>a2:
            B+=1
            if a3>b3:
                A+=1
            elif b3>a3:
                B+=1
            elif a3==b3:
                A+=0
        elif a2==b2:
            A+=0
            if a3>b3:
                A+=1
            elif b3>a3:
                B+=1
            elif a3==b3:
                A+=0
    print(A,B)


def main():
    a1,a2,a3=(int(i) for i in (stdin.readline().split()))
    b1,b2,b3=(int(j) for j in (stdin.readline().split()))
    comparar(a1,a2,a3,b1,b2,b3)



main()
