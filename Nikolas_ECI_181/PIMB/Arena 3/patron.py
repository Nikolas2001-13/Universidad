from sys import stdin

def patron(x):
    if x>0:
        return patron(x//2)
    elif x==1:
        return 1

def main():
    n=int(stdin.readline().strip())
    z=patron(n)
    print(z)
    

main()
