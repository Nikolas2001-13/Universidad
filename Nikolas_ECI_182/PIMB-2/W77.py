from sys import stdin

def poderosos(a1,a2,a3,b1,b2,b3):
    r=a1**2+a2**2+a3**2
    j=b1**2+b2**2+b3**2
    if r==j:
        print("poderosos")
    else:
        print("endebles")

def main():
    a,b=stdin.readline().strip().split()
    a=int(a)
    b=int(b)
    a1=a//100
    a2=(a%100)//10
    a3=((a%100)%10)//1
    b1=b//100
    b2=(b%100)//10
    b3=((b%100)%10)//1
    poderosos(a1,a2,a3,b1,b2,b3)
    

main()
