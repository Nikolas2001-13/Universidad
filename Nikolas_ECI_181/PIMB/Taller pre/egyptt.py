from sys import stdin

a=int(stdin.readline().strip())
b=int(stdin.readline().strip())
c=int(stdin.readline().strip())

def right_triangle():
    if 0<a<30000 and 0<b<30000 and 0<c<30000:
        if a**2==b**2+c**2:
            print ("right")
        elif b**2==a**2+c**2:
            print ("right")
        elif c**2==b**2+a**2:
            print ("right")
        else:
            print ("wrong")
    else:
        print ("wrong")
right_triangle()
