from sys import stdin

def comp(x,y,z):
    if x>=y and x>=z:
        if y<=z:
            return z
        else:
            return y
    elif y>=x and y>=z:
        if x<=z:
            return z
        else:
            return x
    if z>=x and z>=y:
        if y<=x:
            return x
        else:
            return y
    

def main():
    x=int(stdin.readline().strip())
    y=int(stdin.readline().strip())
    z=int(stdin.readline().strip())
    print("Case 1:",comp(x,y,z))

main()
