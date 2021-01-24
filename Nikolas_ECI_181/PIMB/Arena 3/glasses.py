from sys import stdin

def glass(x):
    if x==0:
        return 1
    elif x==1:
        return 2
    else:
        return glass(x-1)+glass(x-2)

def main():
    n=int(stdin.readline().strip())
    z=glass(n)
    print(z)

main()
