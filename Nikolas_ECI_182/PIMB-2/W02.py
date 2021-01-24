from sys import stdin

def res(z):
    if z==1:
        return 2
    else:
        return res(z-1)+z+1

def fact(n):
    if n==0:
        return 1
    else:
        return fact(n-1)*n

def main():
    n=int(stdin.readline().strip())
    z=fact(n)
    print(res(z))
    
    

main()
