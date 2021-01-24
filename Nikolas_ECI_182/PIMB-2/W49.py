from sys import stdin

def ova(n,a):
    if n==1:
        return 2
    else:
        a+=2
        return ova(n-1,a)+a

def main():
    n=int(stdin.readline().strip())
    a=0
    print(ova(n,a),"regiones")


main()
