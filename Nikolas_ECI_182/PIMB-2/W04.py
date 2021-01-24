from sys import stdin

def inv(n):
    if n==0:
        return ""
    else:
        return str(n%10)+str(inv(n//10))

def main():
    n=int(stdin.readline().strip())
    print(inv(n))

main()
