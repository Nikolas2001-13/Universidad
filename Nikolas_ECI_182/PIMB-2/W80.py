from sys import stdin

def prime(n):
    if n==1:
        print("Prime")
    elif n==2:
        print("Prime")
    elif n==3:
        print("Prime")
    elif n==5:
        print("Prime")
    else:
        if n%2==0:
            print("Not prime")
        elif n%3==0:
            print("Not prime")
        elif n%5==0:
            print("Not prime")
        elif n%3!=0:
            print("Prime")
        else:
            return prime(n-1)


            
def main():
    n=int(stdin.readline().strip())
    prime(n)

main()
