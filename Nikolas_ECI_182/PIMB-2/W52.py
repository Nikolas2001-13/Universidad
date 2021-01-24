from sys import stdin

def mcd(a,b):
    if a>b:
        if a%b==0:
            return b
        else:
            return mcd(b,a%b)
    elif a<b:
        if b%a==0:
            return a
        else:
            return mcd(a,b%a)
    else:
        return a
    
        

def main():
    a=int(stdin.readline().strip())
    b=int(stdin.readline().strip())
    print(mcd(a,b))

main()
