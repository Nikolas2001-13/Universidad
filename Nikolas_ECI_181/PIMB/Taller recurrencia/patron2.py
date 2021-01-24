from sys import stdin

def rec(x):
    if x==1:
        return 4
    else:
        return rec(x-1)*-2
def main():
    n=int(stdin.readline().strip())
    z=rec(n)
    print ("T("+str(n)+")="+str(z))

main()
