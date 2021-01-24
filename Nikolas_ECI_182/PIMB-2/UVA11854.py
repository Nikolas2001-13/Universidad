from sys import stdin

def tri(x,y,z):
    if x>y and x>z:
        if x**2==y**2+z**2:
            print("right")
        else:
            print("wrong")
    elif y>x and y>z:
        if y**2==x**2+z**2:
            print("right")
        else:
            print("wrong")
    elif z>x and z>y:
        if z**2==x**2+y**2:
            print("right")
        else:
            print("wrong")

def main():
    x=int(stdin.readline().strip())
    y=int(stdin.readline().strip())
    z=int(stdin.readline().strip())
    tri(x,y,z)

main()
