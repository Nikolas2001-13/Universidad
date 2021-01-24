from sys import stdin

def fact(x):
    if x==0:
        return 1
    elif x>0:
        return x*fact(x-1)
def main():
    n=int(stdin.readline().strip())
    z=fact(n)
    print(str(n)+"!="+str(z))

main()
