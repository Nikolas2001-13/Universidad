from sys import stdin

def ovalo(x):
    if x==1:
        return 2
    elif x==2:
        return 4
    else:
        return ovalo(x-1)-ovalo(x-2)+ovalo(x-1)+2
def main():
    n=int(stdin.readline().strip())
    z=ovalo(n)
    print (z,"regiones")

main()
