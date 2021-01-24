from sys import stdin

def prime(x):
    if x<2:
        return 1
    for i in range(2,x):
        if x%i==0:
            return 0
    else:
        return 1

def main():
    n=int(stdin.readline().strip())
    b=1
    while n!=0:
        x=[int(j) for j in stdin.readline().strip().split(',')]
        a=0
        for k in x:
            a+=prime(k)
        print("Caso",b,":",a,"Primos")
        b+=1
        n-=1

main()
