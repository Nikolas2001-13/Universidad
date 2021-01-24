from sys import stdin

def pat(n):
    if n==1:
        return 4
    else:
        return pat(n-1)*-2

def main():
    n=int(stdin.readline().strip())
    print("T("+str(n)+")="+str(pat(n)))

main()
