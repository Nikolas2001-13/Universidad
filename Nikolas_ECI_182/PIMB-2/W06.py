from sys import stdin

def tri(n):
    if n==1:
        return 1
    else:
        return tri(n-1)+n

def main():
    n=int(stdin.readline().strip())
    print("T("+str(n)+")="+str(tri(n)))


main()
