from sys import stdin

def bina(n,a,c):
    if a==c:
        return 0
    else:
        a+=1
        return ((n%10)*(2**a))+bina(n//10,a,c)

def main():
    n=int(stdin.readline().strip())
    a=-1
    c=len(str(n))
    print(bina(n,a,c))


main()
