from sys import stdin

def menor(a,b,c):
    if a%2==0 and b%2==0 and c%2==0:
        print(min(a,b,c))
    elif a%2==0 and b%2==0 and c%2!=0:
        print(min(a,b))
    elif a%2==0 and b%2!=0 and c%2==0:
        print(min(a,c))
    elif a%2==0 and b%2!=0 and c%2!=0:
        print(a)
    elif a%2!=0 and b%2==0 and c%2!=0:
        print(b)
    elif a%2!=0 and b%2!=0 and c%2==0:
        print(c)
    else:
        print("Sin Par")
    
    
def main():
    a,b,c=stdin.readline().strip().split(',')
    a=int(a)
    b=int(b)
    c=int(c)
    menor(a,b,c)

main()
