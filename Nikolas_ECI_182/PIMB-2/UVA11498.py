from sys import stdin

def coor(x,y,b,c):
    if b==x or c==y:
        print("divisa")
    elif b>x and c>y:
        print("NE")
    elif b>x and c<y:
        print("SE")
    elif b<x and c>y:
        print("NO")
    elif b<x and c<y:
        print("SO")
        

def main():
    n=int(stdin.readline().strip())
    while n!=0:
        x,y=stdin.readline().strip().split()
        x=int(x)
        y=int(y)
        for i in range(n):
            b,c=stdin.readline().strip().split()
            b=int(b)
            c=int(c)
            coor(x,y,b,c)
        n=int(stdin.readline().strip())
        
main()
            
            
            
