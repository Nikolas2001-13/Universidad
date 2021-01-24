from sys import stdin

def prime(n):
    a=0
    if n==1:
        a+=1
    elif n==2:
        a+=1
    elif n==3:
        a+=1
    elif n==5:
        a+=1
    else:
        if n%2==0:
            a+=0
        elif n%3==0:
            a+=0
        elif n%5==0:
            a+=0
        elif n%3!=0:
            a+=1
        else:
            return prime(n-1)
    return a

def main():
    n=[int(i) for i in stdin.readline().strip().split(',')]
    z=0
    for j in n:
        z+=prime(j)
    print("Number of primes in the list:",z)

main()
    

    
